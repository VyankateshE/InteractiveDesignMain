// var fs = require('fs');
// const fs1 = require('fs').promises;
// const puppeteer = require('puppeteer');

// const _sendResponse = require('../../app/helper/global').sendResponse;
// const _errorResponse = require('../../app/helper/global').errorResponse;
// const _validationErrors = require('../../app/helper/global').validationErrors;

// // const creditRepositoryR = require('../../repositories/creditRepository');
// // const creditRepository = new creditRepositoryR();

// class locationController {
//     constructor() { }

//     async listlocation(req, res) {
//         try {
//             let listlocation = {
//                 "city": "Mumbai"
//             }
//             //var cartData1 = await cartdata(req,res)
//             _sendResponse(res, 200, "locationship List", listlocation);

//         } catch (err) {
//             if (err.errors) {
//                 _validationErrors(res, err.errors);
//             } else if (err.message == undefined) {
//                 let error = err.split('|');
//                 _sendResponse(res, error[1], error[0]);
//             } else {
//                 _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//             }
//         }

//     }

//     async uploadHTML(req, res) {
//         try {

//             // var upload = uploadFile.single('file_new')
//             // let path =
//             //     __basedir + "/uploads/" + req.file.filename;
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//                 //return res.status(400).send("Please upload an excel file!");
//             }
//             const htmlBuffer = req.file.buffer;
//             let path =
//                 __basedir + "/uploads/" + req.file.filename;

//             const browser = await puppeteer.launch({ headless: 'new' });
//             const page = await browser.newPage();
//             await page.goto(`file://${path}`, { waitUntil: 'networkidle2' });

//             // await page.evaluate(() => {
//             //     document.getElementById('defaultPDF').click();
//             // });
//             const client = await page.target().createCDPSession();
//             await client.send('Page.setDownloadBehavior', {
//                 behavior: 'allow',
//                 downloadPath: '/home/ubuntu/Projects/EAClub/downloads', // Specify your desired download path
//             });
//             // const browserContext = browser.defaultBrowserContext();

//             // // Set the download path for files
//             // await browserContext.setDefaultOptions({
//             //     downloadPath: '/home/ubuntu/EAClub/downloads', // Specify your desired download path
//             // });

//             // Open the temporary HTML file

//             // Generate PDF from the HTML file
//             const pdf = await page.pdf({ format: 'A4' });

//             // Close the browser
//             await browser.close();

//             // var fileUrl = await locationUtils.uploadFiles3(req, path);

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', 'attachment; filename=output.pdf');
//             res.status(200).send(pdf);
//             // _sendResponse(res, 200, "Excel File Uploaded", fileUrl);

//             // Clean up: Delete the temporary HTML file
//             await fs1.unlink(path);

//             //  var cartData1 = await cartdata(req, res)

//         } catch (err) {
//             //throw err;
//             if (err.errors) {
//                 _validationErrors(res, err.errors);
//             } else if (err.message == undefined) {
//                 let error = err.split('|');
//                 _sendResponse(res, error[1], error[0]);
//             } else {
//                 _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//             }
//         }

//     }

// }
// module.exports = locationController;

//full width of screen
var fs = require("fs");
const fs1 = require("fs").promises;
const puppeteer = require("puppeteer");
const path = require("path");
const { execSync } = require("child_process")


// const { _sendResponse, _errorResponse, _validationErrors } = require("../../app/helper/global");

const _sendResponse = require("../../app/helper/global").sendResponse;
const _errorResponse = require("../../app/helper/global").errorResponse;
const _validationErrors = require("../../app/helper/global").validationErrors;

class locationController {
  constructor() {}

  async listlocation(req, res) {
    try {
      let listlocation = {
        city: "Mumbai",
      };
      _sendResponse(res, 200, "locationship List", listlocation);
    } catch (err) {
      if (err.errors) {
        _validationErrors(res, err.errors);
      } else if (err.message == undefined) {
        let error = err.split("|");
        _sendResponse(res, error[1], error[0]);
      } else {
        _errorResponse(res, 500, "Internal Server Error :: " + err.message);
      }
    }
  }

 async uploadHtmlSinglePage(req, res) {
  try {
    if (!req.file) {
      _sendResponse(res, 400, "Please upload an html file!");
      return;
    }

    const path = __basedir + "/uploads/" + req.file.filename;
    let htmlContent = await fs1.readFile(path, "utf8");



//    htmlContent = htmlContent.replace(
//   /<iframe[^>]*src="https:\/\/maps\.google\.com[^"]*"[^>]*><\/iframe>/gi,
//   `<img src="https://staticmap.openstreetmap.de/staticmap.php?center=20,78&zoom=4&size=600x400&maptype=mapnik"
//         alt="Map" style="display:block;margin:auto;border:1px solid #ccc;" />`
// );

    const injectCSS = `
      <style>
        * {
          -webkit-print-color-adjust: exact !important;
          print-color-adjust: exact !important;
          box-sizing: border-box !important;
        }

        html, body {
          margin: 0 !important;
          padding: 0 !important;
          width: 100% !important;
          height: auto !important;
          background: transparent !important;
        }

        @page {
          size: auto;
          margin: 0mm !important;
        }

        body::after {
          content: none !important;
          display: none !important;
        }

        div, section, article, table, ul, ol, p, h1, h2, h3, h4, h5, h6 {
          page-break-inside: avoid !important;
          margin-bottom: 0 !important;
        }
      </style>
    `;

    if (htmlContent.includes("</head>")) {
      htmlContent = htmlContent.replace("</head>", `${injectCSS}</head>`);
    } else if (htmlContent.includes("<body>")) {
      htmlContent = htmlContent.replace("<body>", `<body>${injectCSS}`);
    } else {
      htmlContent = injectCSS + htmlContent;
    }

    const modifiedPath = path.replace(".html", "_modified.html");
    await fs1.writeFile(modifiedPath, htmlContent);

const browser = await puppeteer.launch({
  headless: "new",
  args: [
    "--no-sandbox",
    "--disable-setuid-sandbox",
    "--enable-webgl",
    "--ignore-gpu-blocklist",
    "--use-gl=desktop",
    "--enable-accelerated-2d-canvas",
    "--enable-gpu-rasterization",
    "--disable-dev-shm-usage",
  ],
});


    const page = await browser.newPage(); 

await page.goto(`file://${modifiedPath}`, {
  waitUntil: 'networkidle2',
  timeout: 120000,
});
await page.waitForTimeout(5000);


    const clip = await page.evaluate(() => {
      const body = document.body;
      const rect = body.getBoundingClientRect();
      return {
        x: 0,
        y: 0,
        width: Math.ceil(rect.width),
        height: Math.ceil(rect.height),
      };
    });

    const pdf = await page.pdf({
      printBackground: true,
      width: `${clip.width}px`,
      height: `${clip.height}px`,
      margin: { top: 0, right: 0, bottom: 0, left: 0 },
      preferCSSPageSize: false,
      pageRanges: "1",
    });

    await browser.close();

    res.setHeader("Content-Type", "application/pdf");
    res.setHeader(
      "Content-Disposition",
      `attachment; filename=uploadHTML_${Date.now()}.pdf`
    );
    res.status(200).send(pdf);

    await fs1.unlink(path);
    await fs1.unlink(modifiedPath);
  } catch (err) {
    if (err.errors) _validationErrors(res, err.errors);
    else if (!err.message) {
      let error = err.split("|");
      _sendResponse(res, error[1], error[0]);
    } else {
      _errorResponse(res, 500, "Internal Server Error :: " + err.message);
    }
  }
}


  async uploadHTML(req, res) {
    try {
      if (req.file == undefined) {
        _sendResponse(res, 400, "Please upload an html file!");
        return;
      }
      const path = __basedir + "/uploads/" + req.file.filename;

      const browser = await puppeteer.launch({ headless: "new" });
      const page = await browser.newPage();
      await page.setViewport({ width: 794, height: 1123 }); 

      await page.goto(`file://${path}`, {
        waitUntil: "networkidle2",
        timeout: 60000,
      });

      await page.waitForTimeout(2000);

      const pdf = await page.pdf({
        format: "A4",
        printBackground: true,
        margin: {
          top: "0px",
          right: "0px",
          bottom: "0px",
          left: "0px",
        },
      });

      await browser.close();

      res.setHeader("Content-Type", "application/pdf");
      res.setHeader(
        "Content-Disposition",
        `attachment; filename=uploadHTML_${Date.now()}.pdf`
      );
      res.status(200).send(pdf);

      await fs1.unlink(path);
    } catch (err) {
      //throw err;
      if (err.errors) {
        _validationErrors(res, err.errors);
      } else if (err.message == undefined) {
        let error = err.split("|");
        _sendResponse(res, error[1], error[0]);
      } else {
        _errorResponse(res, 500, "Internal Server Error :: " + err.message);
      }
    }
  }


  async uploadHTML2(req, res) {
  try {
    if (!req.file) {
      _sendResponse(res, 400, "Please upload an HTML file!");
      return;
    }

    const htmlPath = path.join(__basedir, "uploads", req.file.filename);
    const outputDir = path.join(__basedir, "uploads", "converted");
    if (!fs.existsSync(outputDir)) fs.mkdirSync(outputDir, { recursive: true });

    const pdfPath = path.join(outputDir, `temp_${Date.now()}.pdf`);
    const rtfPath = path.join(outputDir, `converted_${Date.now()}.rtf`);

    // Step 1️⃣: Launch Puppeteer to render HTML → PDF
    const browser = await puppeteer.launch({ headless: "new" });
    const page = await browser.newPage();
    await page.setViewport({ width: 794, height: 1123 }); // A4 size

    await page.goto(`file://${htmlPath}`, {
      waitUntil: "networkidle2",
      timeout: 60000,
    });

    await page.waitForTimeout(2000);

    await page.pdf({
      path: pdfPath,
      format: "A4",
      printBackground: true,
      margin: { top: "0px", right: "0px", bottom: "0px", left: "0px" },
    });

    await browser.close();
    console.log("✅ PDF successfully created:", pdfPath);

    // Step 2️⃣: Convert PDF → RTF using LibreOffice
    console.log("🔄 Converting PDF to RTF...");
    execSync(`soffice --headless --convert-to rtf "${pdfPath}" --outdir "${outputDir}"`);

    // LibreOffice creates file with same base name but .rtf extension
    const generatedRtf = pdfPath.replace(/\.pdf$/, ".rtf");

    // Step 3️⃣: Return RTF as response
    const rtfBuffer = fs.readFileSync(generatedRtf);

    res.setHeader("Content-Type", "application/rtf");
    res.setHeader(
      "Content-Disposition",
      `attachment; filename=converted_${Date.now()}.rtf`
    );
    res.status(200).send(rtfBuffer);

    // Step 4️⃣: Cleanup temp files
    await fs1.unlink(htmlPath).catch(() => {});
    await fs1.unlink(pdfPath).catch(() => {});
    await fs1.unlink(generatedRtf).catch(() => {});

    console.log("✅ Temporary files cleaned up.");
  } catch (err) {
    console.error("❌ Error in uploadHTML2:", err);
    if (err.errors) {
      _validationErrors(res, err.errors);
    } else if (!err.message) {
      const error = err.split("|");
      _sendResponse(res, error[1], error[0]);
    } else {
      _errorResponse(res, 500, "Internal Server Error :: " + err.message);
    }
  }
}

  // async uploadHTML2(req, res) {
  //   try {
  //     if (req.file == undefined) {
  //       _sendResponse(res, 400, "Please upload an HTML file!");
  //       return;
  //     }

  //     const path = __basedir + "/uploads/" + req.file.filename;

  //     // // Launch Puppeteer
  //     // const browser = await puppeteer.launch({
  //     //   headless: 'new',
  //     //   args: [
  //     //     '--no-sandbox',
  //     //     '--disable-setuid-sandbox',
  //     //     '--disable-dev-shm-usage',
  //     //     '--disable-gpu'
  //     //   ]
  //     // });
  //     const browser = await puppeteer.launch({ headless: "new" });

  //     const page = await browser.newPage();

  //     // ✅ Set viewport to exact A4 size (portrait)
  //     await page.setViewport({ width: 794, height: 1123 }); // A4 size in pixels (96 DPI)

  //     // Load HTML file
  //     await page.goto(`file://${path}`, {
  //       waitUntil: "networkidle2",
  //       timeout: 60000,
  //     });

  //     await page.waitForTimeout(2000);

  //     // ✅ Generate A4-sized PDF (fixed, no scaling beyond A4)
  //     const pdf = await page.pdf({
  //       format: "A4",
  //       printBackground: true,
  //       margin: {
  //         top: "0px",
  //         right: "0px",
  //         bottom: "0px",
  //         left: "0px",
  //       },
  //       //   scale: 1
  //     });

  //     await browser.close();

  //     // Send PDF response
  //     res.setHeader("Content-Type", "application/pdf");
  //     res.setHeader(
  //       "Content-Disposition",
  //       `attachment; filename=output_${Date.now()}.pdf`
  //     );
  //     res.status(200).send(pdf);

  //     // Clean up uploaded HTML file
  //     await fs1.unlink(path);
  //   } catch (err) {
  //     if (err.errors) {
  //       _validationErrors(res, err.errors);
  //     } else if (err.message == undefined) {
  //       let error = err.split("|");
  //       _sendResponse(res, error[1], error[0]);
  //     } else {
  //       _errorResponse(res, 500, "Internal Server Error :: " + err.message);
  //     }
  //   }
  // }
}

module.exports = locationController;

// // ALTERNATIVE METHOD: Fixed Large Page Size
// async uploadHTMLFixedSize(req, res) {
//   try {
//     if (req.file == undefined) {
//       _sendResponse(res, 400, "Please upload an html file!");
//       return;
//     }

//     let path = __basedir + "/uploads/" + req.file.filename;

//     const browser = await puppeteer.launch({
//       headless: "new",
//       args: ["--no-sandbox", "--disable-setuid-sandbox"],
//     });

//     const page = await browser.newPage();

//     // Set large viewport
//     await page.setViewport({
//       width: 2480,
//       height: 3508,
//       deviceScaleFactor: 1,
//     });

//     await page.goto(`file://${path}`, {
//       waitUntil: "networkidle2",
//       timeout: 60000,
//     });

//     // Wait for charts and dynamic content
//     await page.waitForTimeout(5000);

//     // Inject CSS to ensure content fits on one page
//     await page.addStyleTag({
//       content: `
//                   @page {
//                       size: A3 landscape;
//                       margin: 0;
//                   }
//                   body {
//                       margin: 10px;
//                       transform: scale(0.75);
//                       transform-origin: top left;
//                       width: 133.33%;
//                   }
//                   * {
//                       page-break-inside: avoid !important;
//                   }
//               `,
//     });

//     // Generate PDF with A3 landscape (or larger)
//     const pdf = await page.pdf({
//       format: "A3", // or 'A2' for even larger
//       landscape: true,
//       printBackground: true,
//       margin: {
//         top: "10mm",
//         right: "10mm",
//         bottom: "10mm",
//         left: "10mm",
//       },
//       preferCSSPageSize: false,
//     });

//     await browser.close();

//     res.setHeader("Content-Type", "application/pdf");
//     res.setHeader(
//       "Content-Disposition",
//       `attachment; filename=output_${Date.now()}.pdf`
//     );
//     res.status(200).send(pdf);

//     await fs1.unlink(path);
//   } catch (err) {
//     _errorResponse(res, 500, "Internal Server Error :: " + err.message);
//   }
// }
// var fs = require('fs');
// const fs1 = require('fs').promises;
// const puppeteer = require('puppeteer');

// const _sendResponse = require('../../app/helper/global').sendResponse;
// const _errorResponse = require('../../app/helper/global').errorResponse;
// const _validationErrors = require('../../app/helper/global').validationErrors;

// class locationController {
//     constructor() { }

//     async listlocation(req, res) {
//         try {
//             let listlocation = {
//                 "city": "Mumbai"
//             }
//             _sendResponse(res, 200, "locationship List", listlocation);
//         } catch (err) {
//             if (err.errors) {
//                 _validationErrors(res, err.errors);
//             } else if (err.message == undefined) {
//                 let error = err.split('|');
//                 _sendResponse(res, error[1], error[0]);
//             } else {
//                 _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//             }
//         }
//     }

//     async uploadHTML(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             const htmlBuffer = req.file.buffer;
//             let path = __basedir + "/uploads/" + req.file.filename;

//             // Launch browser with proper settings
//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: [
//                     '--no-sandbox',
//                     '--disable-setuid-sandbox',
//                     '--disable-dev-shm-usage',
//                     '--disable-gpu'
//                 ]
//             });

//             const page = await browser.newPage();

//             // Set a large viewport to accommodate all content
//             await page.setViewport({
//                 width: 1920,
//                 height: 1080,
//                 deviceScaleFactor: 1,
//             });

//             // Load the HTML file
//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             // Wait for any dynamic content to load (charts, tables, etc.)
//             await page.waitForTimeout(3000);

//             // Get the actual content dimensions
//             const contentDimensions = await page.evaluate(() => {
//                 const body = document.body;
//                 const html = document.documentElement;

//                 const height = Math.max(
//                     body.scrollHeight,
//                     body.offsetHeight,
//                     html.clientHeight,
//                     html.scrollHeight,
//                     html.offsetHeight
//                 );

//                 const width = Math.max(
//                     body.scrollWidth,
//                     body.offsetWidth,
//                     html.clientWidth,
//                     html.scrollWidth,
//                     html.offsetWidth
//                 );

//                 return { width, height };
//             });

//             console.log('Content dimensions:', contentDimensions);

//             // Calculate page dimensions with some padding
//             const pageWidth = Math.max(contentDimensions.width + 40, 1200);
//             const pageHeight = Math.max(contentDimensions.height + 40, 1600);

//             // Generate PDF with custom dimensions to fit all content on single page
//             const pdf = await page.pdf({
//                 width: `${pageWidth}px`,
//                 height: `${pageHeight}px`,
//                 printBackground: true,
//                 margin: {
//                     top: '20px',
//                     right: '20px',
//                     bottom: '20px',
//                     left: '20px'
//                 },
//                 preferCSSPageSize: false,
//                 scale: 0.8 // Scale down to fit more content
//             });

//             // Close the browser
//             await browser.close();

//             // Send PDF response
//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=output_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             // Clean up: Delete the temporary HTML file
//             await fs1.unlink(path);

//         } catch (err) {
//             if (err.errors) {
//                 _validationErrors(res, err.errors);
//             } else if (err.message == undefined) {
//                 let error = err.split('|');
//                 _sendResponse(res, error[1], error[0]);
//             } else {
//                 _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//             }
//         }
//     }

//     // ALTERNATIVE METHOD: Fixed Large Page Size
//     async uploadHTMLFixedSize(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             let path = __basedir + "/uploads/" + req.file.filename;

//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: ['--no-sandbox', '--disable-setuid-sandbox']
//             });

//             const page = await browser.newPage();

//             // Set large viewport
//             await page.setViewport({
//                 width: 2480,
//                 height: 3508,
//                 deviceScaleFactor: 1,
//             });

//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             // Wait for charts and dynamic content
//             await page.waitForTimeout(5000);

//             // Inject CSS to ensure content fits on one page
//             await page.addStyleTag({
//                 content: `
//                     @page {
//                         size: A3 landscape;
//                         margin: 0;
//                     }
//                     body {
//                         margin: 10px;
//                         transform: scale(0.75);
//                         transform-origin: top left;
//                         width: 133.33%;
//                     }
//                     * {
//                         page-break-inside: avoid !important;
//                     }
//                 `
//             });

//             // Generate PDF with A3 landscape (or larger)
//             const pdf = await page.pdf({
//                 format: 'A3', // or 'A2' for even larger
//                 landscape: true,
//                 printBackground: true,
//                 margin: {
//                     top: '10mm',
//                     right: '10mm',
//                     bottom: '10mm',
//                     left: '10mm'
//                 },
//                 preferCSSPageSize: false
//             });

//             await browser.close();

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=output_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             await fs1.unlink(path);

//         } catch (err) {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }

//     // A4 Portrait - Single Page (Default)
//     async uploadHTMLCustomSize(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             // A4 dimensions: Portrait (210mm x 297mm) or Landscape (297mm x 210mm)
//             const orientation = req.query.orientation || 'portrait'; // 'portrait' or 'landscape'
//             const pageWidth = orientation === 'portrait' ? 210 : 297;
//             const pageHeight = orientation === 'portrait' ? 297 : 210;
//             const scaleFactor = req.query.scale || 0.5; // Reduced scale to fit more content on A4

//             let path = __basedir + "/uploads/" + req.file.filename;

//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: ['--no-sandbox', '--disable-setuid-sandbox']
//             });

//             const page = await browser.newPage();

//             // Convert mm to pixels (96 DPI)
//             const widthPx = Math.floor((pageWidth / 25.4) * 96);
//             const heightPx = Math.floor((pageHeight / 25.4) * 96);

//             await page.setViewport({
//                 width: widthPx,
//                 height: heightPx,
//                 deviceScaleFactor: 1,
//             });

//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             // Wait for all content including charts
//             await page.waitForTimeout(5000);

//             // Inject CSS to fit ALL content on single A4 page
//             await page.addStyleTag({
//                 content: `
//                     @page {
//                         size: ${pageWidth}mm ${pageHeight}mm;
//                         margin: 0;
//                     }
//                     body {
//                         margin: 3mm;
//                         transform: scale(${scaleFactor});
//                         transform-origin: top left;
//                         width: ${100 / scaleFactor}%;
//                         height: ${100 / scaleFactor}%;
//                         overflow: hidden;
//                     }
//                     * {
//                         page-break-inside: avoid !important;
//                         page-break-after: avoid !important;
//                         page-break-before: avoid !important;
//                     }
//                     img, figure, table, .row, div {
//                         page-break-inside: avoid !important;
//                     }
//                     table {
//                         font-size: 8px !important;
//                     }
//                     h1, h2, h3, h4, h5, h6 {
//                         font-size: 12px !important;
//                         margin: 2px 0 !important;
//                     }
//                 `
//             });

//             // Generate PDF with A4 size
//             const pdf = await page.pdf({
//                 width: `${pageWidth}mm`,
//                 height: `${pageHeight}mm`,
//                 printBackground: true,
//                 margin: {
//                     top: '3mm',
//                     right: '3mm',
//                     bottom: '3mm',
//                     left: '3mm'
//                 },
//                 preferCSSPageSize: true,
//                 scale: 1
//             });

//             await browser.close();

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=output_A4_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             await fs1.unlink(path);

//         } catch (err) {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }

//     // A4 Portrait with adjustable scaling
//     async uploadHTMLA4(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             let path = __basedir + "/uploads/" + req.file.filename;
//             const scaleFactor = parseFloat(req.query.scale) || 0.5;

//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: ['--no-sandbox', '--disable-setuid-sandbox', '--disable-dev-shm-usage']
//             });

//             const page = await browser.newPage();

//             // A4 viewport
//             await page.setViewport({
//                 width: 794,  // A4 width in pixels at 96 DPI
//                 height: 1123, // A4 height in pixels at 96 DPI
//                 deviceScaleFactor: 1,
//             });

//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             // Wait for dynamic content
//             await page.waitForTimeout(5000);

//             // Inject aggressive CSS to force everything on one A4 page
//             await page.addStyleTag({
//                 content: `
//                     @page {
//                         size: A4 portrait;
//                         margin: 0;
//                     }
//                     html, body {
//                         width: 100%;
//                         height: 100%;
//                         margin: 0;
//                         padding: 0;
//                         overflow: hidden;
//                     }
//                     body > * {
//                         transform: scale(${scaleFactor});
//                         transform-origin: top left;
//                         width: ${100 / scaleFactor}%;
//                     }
//                     * {
//                         page-break-inside: avoid !important;
//                         page-break-after: avoid !important;
//                         page-break-before: avoid !important;
//                     }
//                     .row, .container, div, section, table, img, figure {
//                         page-break-inside: avoid !important;
//                     }
//                     /* Reduce font sizes */
//                     body, p, td, th, div, span {
//                         font-size: 7px !important;
//                         line-height: 1.2 !important;
//                     }
//                     h1 { font-size: 12px !important; margin: 2px 0 !important; }
//                     h2 { font-size: 11px !important; margin: 2px 0 !important; }
//                     h3 { font-size: 10px !important; margin: 1px 0 !important; }
//                     h4, h5, h6 { font-size: 9px !important; margin: 1px 0 !important; }
//                     table { font-size: 6px !important; }
//                     button { font-size: 7px !important; padding: 2px 4px !important; }
//                     /* Reduce spacing */
//                     .row, .container { margin: 1px 0 !important; padding: 2px !important; }
//                 `
//             });

//             // Generate A4 PDF
//             const pdf = await page.pdf({
//                 format: 'A4',
//                 printBackground: true,
//                 margin: {
//                     top: '2mm',
//                     right: '2mm',
//                     bottom: '2mm',
//                     left: '2mm'
//                 },
//                 preferCSSPageSize: true
//             });

//             await browser.close();

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=A4_single_page_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             await fs1.unlink(path);

//         } catch (err) {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }

//     // A4 Landscape version
//     async uploadHTMLA4Landscape(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             let path = __basedir + "/uploads/" + req.file.filename;
//             const scaleFactor = parseFloat(req.query.scale) || 0.55;

//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: ['--no-sandbox', '--disable-setuid-sandbox']
//             });

//             const page = await browser.newPage();

//             await page.setViewport({
//                 width: 1123,  // A4 landscape width
//                 height: 794,  // A4 landscape height
//                 deviceScaleFactor: 1,
//             });

//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             await page.waitForTimeout(5000);

//             await page.addStyleTag({
//                 content: `
//                     @page {
//                         size: A4 landscape;
//                         margin: 0;
//                     }
//                     html, body {
//                         margin: 0;
//                         padding: 0;
//                         overflow: hidden;
//                     }
//                     body > * {
//                         transform: scale(${scaleFactor});
//                         transform-origin: top left;
//                         width: ${100 / scaleFactor}%;
//                     }
//                     * {
//                         page-break-inside: avoid !important;
//                         page-break-after: avoid !important;
//                     }
//                     body, p, td, th { font-size: 7px !important; }
//                     h1 { font-size: 12px !important; }
//                     h2, h3 { font-size: 10px !important; }
//                     table { font-size: 6px !important; }
//                 `
//             });

//             const pdf = await page.pdf({
//                 format: 'A4',
//                 landscape: true,
//                 printBackground: true,
//                 margin: {
//                     top: '2mm',
//                     right: '2mm',
//                     bottom: '2mm',
//                     left: '2mm'
//                 },
//                 preferCSSPageSize: true
//             });

//             await browser.close();

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=A4_landscape_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             await fs1.unlink(path);

//         } catch (err) {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }
// }

// module.exports = locationController;

// async uploadHTML2(req, res) {
//     try {
//         if (req.file == undefined) {
//             _sendResponse(res, 400, "Please upload an html file!");
//             return;
//         }

//         const htmlBuffer = req.file.buffer;
//         let path = __basedir + "/uploads/" + req.file.filename;

//         // Launch browser with proper settings
//         const browser = await puppeteer.launch({
//             headless: 'new',
//             args: [
//                 '--no-sandbox',
//                 '--disable-setuid-sandbox',
//                 '--disable-dev-shm-usage',
//                 '--disable-gpu'
//             ]
//         });

//         const page = await browser.newPage();

//         // Set a large viewport to accommodate all content
//         // await page.setViewport({
//         //     width: 1920,
//         //     height: 1080,
//         //     deviceScaleFactor: 1,
//         // });

//                 await page.setViewport({ width: 794, height: 1123 }); // A4 approx in pixels

//         // Load the HTML file
//         await page.goto(`file://${path}`, {
//             waitUntil: 'networkidle2',
//             timeout: 60000
//         });

//         // Wait for any dynamic content to load (charts, tables, etc.)
//         await page.waitForTimeout(3000);

//         // Get the actual content dimensions
//         const contentDimensions = await page.evaluate(() => {
//             const body = document.body;
//             const html = document.documentElement;

//             const height = Math.max(
//                 body.scrollHeight,
//                 body.offsetHeight,
//                 html.clientHeight,
//                 html.scrollHeight,
//                 html.offsetHeight
//             );

//             const width = Math.max(
//                 body.scrollWidth,
//                 body.offsetWidth,
//                 html.clientWidth,
//                 html.scrollWidth,
//                 html.offsetWidth
//             );

//             return { width, height };
//         });

//         console.log('Content dimensions:', contentDimensions);

//         // Calculate page dimensions with some padding
//         const pageWidth = Math.max(contentDimensions.width + 40, 1200);
//         const pageHeight = Math.max(contentDimensions.height + 40, 1600);

//         // Generate PDF with custom dimensions to fit all content on single page
//         const pdf = await page.pdf({
//             width: `${pageWidth}px`,
//             height: `${pageHeight}px`,
//             printBackground: true,
//             margin: {
//                 top: '20px',
//                 right: '20px',
//                 bottom: '20px',
//                 left: '20px'
//             },
//             preferCSSPageSize: false,
//             scale: 0.8 // Scale down to fit more content
//         });

//         // Close the browser
//         await browser.close();

//         // Send PDF response
//         res.setHeader('Content-Type', 'application/pdf');
//         res.setHeader('Content-Disposition', `attachment; filename=output_${Date.now()}.pdf`);
//         res.status(200).send(pdf);

//         // Clean up: Delete the temporary HTML file
//         await fs1.unlink(path);

//     } catch (err) {
//         if (err.errors) {
//             _validationErrors(res, err.errors);
//         } else if (err.message == undefined) {
//             let error = err.split('|');
//             _sendResponse(res, error[1], error[0]);
//         } else {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }
// }
//     // ALTERNATIVE METHOD: Fixed Large Page Size
//     async uploadHTMLFixedSize(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             let path = __basedir + "/uploads/" + req.file.filename;

//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: ['--no-sandbox', '--disable-setuid-sandbox']
//             });

//             const page = await browser.newPage();

//             // Set large viewport
//             await page.setViewport({
//                 width: 2480,
//                 height: 3508,
//                 deviceScaleFactor: 1,
//             });

//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             // Wait for charts and dynamic content
//             await page.waitForTimeout(5000);

//             // Inject CSS to ensure content fits on one page
//             await page.addStyleTag({
//                 content: `
//                     @page {
//                         size: A4;
//                         margin: 0;
//                     }
//                     body {
//                         margin: 10px;
//                         transform: scale(0.75);
//                         transform-origin: top left;
//                         width: 133.33%;
//                     }
//                     * {
//                         page-break-inside: avoid !important;
//                     }
//                 `
//             });

//             // Generate PDF with A3 landscape (or larger)
//             const pdf = await page.pdf({
//                 format: 'A3', // or 'A2' for even larger
//                 landscape: true,
//                 printBackground: true,
//                 margin: {
//                     top: '10mm',
//                     right: '10mm',
//                     bottom: '10mm',
//                     left: '10mm'
//                 },
//                 preferCSSPageSize: false
//             });

//             await browser.close();

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=output_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             await fs1.unlink(path);

//         } catch (err) {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }

//     // BEST METHOD: Custom dimensions with content scaling
//     async uploadHTMLCustomSize(req, res) {
//         try {
//             if (req.file == undefined) {
//                 _sendResponse(res, 400, "Please upload an html file!");
//                 return;
//             }

//             // Get custom dimensions from query params (in mm)
//             const pageWidth = req.query.pageWidth || 420; // A3 landscape width
//             const pageHeight = req.query.pageHeight || 297; // A3 landscape height
//             const scaleFactor = req.query.scale || 0.75;

//             let path = __basedir + "/uploads/" + req.file.filename;

//             const browser = await puppeteer.launch({
//                 headless: 'new',
//                 args: ['--no-sandbox', '--disable-setuid-sandbox']
//             });

//             const page = await browser.newPage();

//             // Convert mm to pixels (96 DPI)
//             const widthPx = Math.floor((pageWidth / 25.4) * 96);
//             const heightPx = Math.floor((pageHeight / 25.4) * 96);

//             await page.setViewport({
//                 width: widthPx,
//                 height: heightPx,
//                 deviceScaleFactor: 1,
//             });

//             await page.goto(`file://${path}`, {
//                 waitUntil: 'networkidle2',
//                 timeout: 60000
//             });

//             // Wait for all content including charts
//             await page.waitForTimeout(5000);

//             // Inject CSS to fit content on single page
//             await page.addStyleTag({
//                 content: `
//                     @page {
//                         size: ${pageWidth}mm ${pageHeight}mm;
//                         margin: 0;
//                     }
//                     body {
//                         margin: 5mm;
//                         transform: scale(${scaleFactor});
//                         transform-origin: top left;
//                         width: ${100 / scaleFactor}%;
//                         overflow: hidden;
//                     }
//                     * {
//                         page-break-inside: avoid !important;
//                         page-break-after: avoid !important;
//                         page-break-before: avoid !important;
//                     }
//                     img, figure, table, .row {
//                         page-break-inside: avoid !important;
//                     }
//                 `
//             });

//             // Generate PDF
//             const pdf = await page.pdf({
//                 width: `${pageWidth}mm`,
//                 height: `${pageHeight}mm`,
//                 printBackground: true,
//                 margin: {
//                     top: '5mm',
//                     right: '5mm',
//                     bottom: '5mm',
//                     left: '5mm'
//                 },
//                 preferCSSPageSize: true
//             });

//             await browser.close();

//             res.setHeader('Content-Type', 'application/pdf');
//             res.setHeader('Content-Disposition', `attachment; filename=output_${Date.now()}.pdf`);
//             res.status(200).send(pdf);

//             await fs1.unlink(path);

//         } catch (err) {
//             _errorResponse(res, 500, 'Internal Server Error :: ' + err.message);
//         }
//     }
// }
