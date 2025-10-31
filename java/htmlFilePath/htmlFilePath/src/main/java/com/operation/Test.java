package com.operation;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Test {
	
	private static final String ALGORITHM = "AES";
	
//	private static String k2 = "ariantechsolutionsprivatelimitedmaladmumbai=";
	
	private static String k2 = "ariantechsolutions1234";

	public static void main(String[] args) throws Exception {


//		KeyGenerator keyGenerator = null;
//			
//			keyGenerator = KeyGenerator.getInstance(ALGORITHM);
//		
//      keyGenerator.init(256); // 256-bit key
//      SecretKey secretKey = keyGenerator.generateKey();
//      
//      byte[] encodedKey = secretKey.getEncoded();
//      String encodedKeyString = Base64.getEncoder().encodeToString(encodedKey);
		
		
		
//		String k = "ram my friend const a=\"krushna\";function _0x40ef(){const";
//		
//		String k3 = "const a=";
//		
//		k = k.replaceAll("friend", "friend66");
//		
//		System.out.println(k);
//		
//		
//		System.out.println(k.substring( k.indexOf(k3)+k3.length()+1 , k.indexOf("function _0x40ef(){const")-2 ));
		
//		String encodedKeyString = "xAMSGeTpvhzhgKFpOTIBygqV3c5nXU+zizOPMbJLwSM=";
//		
//		System.out.println(encodedKeyString.length());
//		
//		String k1 = "krushnakolheKRUSHNAKOLHEkrushnakolheKRUSHNA=";
//		
//		;
//		
//		System.out.println(k1.length());
//      
      
     String k1 = "<!doctype html>\r\n"
     		+ "<html lang=\"en\">\r\n"
     		+ "\r\n"
     		+ "<head>\r\n"
     		+ "    <meta charset=\"utf-8\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/v/bs4/dt-1.13.2/datatables.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css\">\r\n"
     		+ "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n"
     		+ "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\r\n"
     		+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
     		+ "    <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js\"></script>\r\n"
     		+ "    <script src=\"https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js\"></script>\r\n"
     		+ "    <script src=\"https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js\"></script>\r\n"
     		+ "    <script src=\"https://code.highcharts.com/highcharts.js\"></script>\r\n"
     		+ "    <script src=\"https://code.highcharts.com/modules/drilldown.js\"></script>\r\n"
     		+ "    <style>\r\n"
     		+ "        * {\r\n"
     		+ "            box-sizing: border-box;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        body {\r\n"
     		+ "            margin: 0;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        * {\r\n"
     		+ "            box-sizing: border-box;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        body {\r\n"
     		+ "            margin: 0;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        * {\r\n"
     		+ "            box-sizing: border-box;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        body {\r\n"
     		+ "            margin: 0;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #imw3 {\r\n"
     		+ "            width: 100%;\r\n"
     		+ "            padding: 10px 0px;\r\n"
     		+ "            margin-left: 0px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #i2vk {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #ighr {\r\n"
     		+ "            width: 100%;\r\n"
     		+ "            padding: 10px 0px;\r\n"
     		+ "            margin-left: 0px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #idcn {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #ieaa {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #imip {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #i0eb {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #igib {\r\n"
     		+ "            width: 100%;\r\n"
     		+ "            padding: 10px 0px;\r\n"
     		+ "            margin-left: 0px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #ir5w {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #igoeo {\r\n"
     		+ "            width: 100%;\r\n"
     		+ "            padding: 10px 0px;\r\n"
     		+ "            margin-left: 0px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #idhbe {\r\n"
     		+ "            min-height: 45px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #i87pk {\r\n"
     		+ "            padding: 10px;\r\n"
     		+ "            my-input-json: SA[0].name;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #igl3g {\r\n"
     		+ "            padding: 10px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #i490j {\r\n"
     		+ "            padding: 10px;\r\n"
     		+ "            my-input-json: SA[0].surname;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #i4g7g {\r\n"
     		+ "            padding: 10px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #igort {\r\n"
     		+ "            padding: 10px 0px;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        .highlight_text {\r\n"
     		+ "            background-color: yellow\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        .i_designer-selected {\r\n"
     		+ "            outline: none !important;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #main-nav-div .hamburger-menu {\r\n"
     		+ "            display: none !important;\r\n"
     		+ "            text-align: right;\r\n"
     		+ "            font-size: 30px;\r\n"
     		+ "            padding: 10px;\r\n"
     		+ "            color: #472e90;\r\n"
     		+ "            cursor: pointer;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        @media (max-width: 991px) {\r\n"
     		+ "            #main-nav-div .hamburger-menu {\r\n"
     		+ "                display: block !important;\r\n"
     		+ "            }\r\n"
     		+ "\r\n"
     		+ "            #main-nav-div .tab-container,\r\n"
     		+ "            #main-nav-div .tab {\r\n"
     		+ "                width: 99%;\r\n"
     		+ "                text-align: center;\r\n"
     		+ "            }\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        @media (max-width: 767px) {\r\n"
     		+ "            #main-nav-div .hamburger-menu {\r\n"
     		+ "                display: block !important;\r\n"
     		+ "            }\r\n"
     		+ "\r\n"
     		+ "            #main-nav-div .tab-container,\r\n"
     		+ "            #main-nav-div .tab {\r\n"
     		+ "                width: 98%;\r\n"
     		+ "            }\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        #google_translate_element {\r\n"
     		+ "            padding: 5px !important;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        .VIpgJd-ZVi9od-ORHb-OEVmcd,\r\n"
     		+ "        .goog-te-gadget-simple img {\r\n"
     		+ "            display: none !important;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        .goog-te-gadget-simple .VIpgJd-ZVi9od-xl07Ob-lTBxed span {\r\n"
     		+ "            padding-right: 5px\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        .VIpgJd-yAWNEb-L7lbkb {\r\n"
     		+ "            display: none !important\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        body {\r\n"
     		+ "            top: 0px !important;\r\n"
     		+ "        }\r\n"
     		+ "\r\n"
     		+ "        .dataTables_scrollHeadInner {\r\n"
     		+ "            width: 100% !important;\r\n"
     		+ "        }\r\n"
     		+ "    </style>\r\n"
     		+ "</head>\r\n"
     		+ "\r\n"
     		+ "<body>\r\n"
     		+ "    <div id=\"AllBodyData\">\r\n"
     		+ "        <div id=\"defaultPDF\" style=\"display:none\"></div>\r\n"
     		+ "        <div id=\"google_translate_element\"></div>\r\n"
     		+ "        <script>\r\n"
     		+ "            const googleTranslaterF = 'Yes'; if (googleTranslaterF !== 'Yes') { let googleTranslateDiv = document.getElementById('google_translate_element'); if (googleTranslateDiv !== null && googleTranslateDiv !== undefined) { googleTranslateDiv.parentNode.removeChild(googleTranslateDiv); } } var project_type2 = 'downloadedJsonType'; var jsonData1=[{\"english\":{\"audioLink\":\"https://www.w3schools.com/html/horse.mp3\",\"content\":\"Contentgoesherecontentgoeshere\",\"content1\":\"TestDatacontent1\",\"videoLink\":\"\",\"SA\":[{\"name\":\"Krushna\",\"surname\":\"Kolhe\",\"address\":\"Jalna\"}],\"transactions1Tbl\":{\"heading\":{\"Date\":\"Date\",\"Type\":\"Type\",\"Narration\":\"Narration\",\"FCY_GBP\":\"FCY(GBP)\",\"CurrentRate\":\"CurrenttRate\",\"LCY_GBP\":\"LCY(GBP)\"},\"caption\":\"CaptionTextHere\",\"footer\":{\"Date\":\"12-08-2023\",\"Type\":\"CR\",\"Narration\":\"NEFT\",\"FCY_GBP\":\"88\",\"CurrentRate\":\"12\",\"LCY_GBP\":\"33\"},\"data\":[{\"Date\":\"3-APR-15\",\"Type\":\"CR\",\"Narration\":\"NE\",\"FCY_GBP\":\"1999.67\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"1\"},{\"Date\":\"1-APR-15\",\"Type\":\"CR\",\"Narration\":\"NEFT:10204083732-THEGREATERBankofNewYork\",\"FCY_GBP\":\"0.98\",\"CurrentRate\":\"2.45\",\"LCY_GBP\":\"5\"},{\"Date\":\"1-APR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:FUNDSTRFFROM000490700001137\",\"FCY_GBP\":\"67.56\",\"CurrentRate\":\"1.786\",\"LCY_GBP\":\"10\"},{\"Date\":\"31-MAR-15\",\"Type\":\"CR\",\"Narration\":\"NETTXN:IIFLIIFL3557346\",\"FCY_GBP\":\"7.37\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"4\"},{\"Date\":\"31-MAR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:IIFLIIFL3557346\",\"FCY_GBP\":\"-1151.91\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"5\"},{\"Date\":\"31-MAR-15\",\"Type\":\"DR\",\"Narration\":\"LD1508340249\",\"FCY_GBP\":\"7.37\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"6\"},{\"Date\":\"24-MAR-15\",\"Type\":\"DR\",\"Narration\":\"PCI:0500010827:1000156311283:ODELPLC-459050\",\"FCY_GBP\":\"-30.64\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"7\"},{\"Date\":\"24-MAR-15\",\"Type\":\"CR\",\"Narration\":\"PCD:0500010827:9993715077628:COTTONCOLL-085222\",\"FCY_GBP\":\"1696.21\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"8\"},{\"Date\":\"24-MAR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:RENTFORFEB2013\",\"FCY_GBP\":\"-296.46\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"9\"},{\"Date\":\"1-APR-15\",\"Type\":\"CR\",\"Narration\":\"NEFT:10204083732-THEGREATERBankofNewYork\",\"FCY_GBP\":\"0.38\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"10\"},{\"Date\":\"1-APR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:FUNDSTRFFROM000490700001137\",\"FCY_GBP\":\"-5017.56\",\"CurrentRate\":\"1.560\",\"LCY_GBP\":\"11\"},{\"Date\":\"31-MAR-15\",\"Type\":\"CR\",\"Narration\":\"NETTXN:IIFLIIFL3557346\",\"FCY_GBP\":\"7.37\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"12\"},{\"Date\":\"31-MAR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:IIFLIIFL3557346\",\"FCY_GBP\":\"-1151.91\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"13\"},{\"Date\":\"31-MAR-15\",\"Type\":\"DR\",\"Narration\":\"LD1508340249\",\"FCY_GBP\":\"7.37\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"14\"},{\"Date\":\"24-MAR-15\",\"Type\":\"DR\",\"Narration\":\"PCI:0500010827:1000156311283:ODELPLC-459050\",\"FCY_GBP\":\"-30.64\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"15\"},{\"Date\":\"24-MAR-15\",\"Type\":\"CR\",\"Narration\":\"PCD:0500010827:9993715077628:COTTONCOLL-085222\",\"FCY_GBP\":\"1696.21\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"16\"},{\"Date\":\"24-MAR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:RENTFORFEB2013\",\"FCY_GBP\":\"-296.46\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"17\"},{\"Date\":\"1-APR-15\",\"Type\":\"CR\",\"Narration\":\"NEFT:10204083732-THEGREATERBankofNewYork\",\"FCY_GBP\":\"0.38\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"18\"},{\"Date\":\"1-APR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:FUNDSTRFFROM000490700001137\",\"FCY_GBP\":\"-5017.56\",\"CurrentRate\":\"1.560\",\"LCY_GBP\":\"19\"},{\"Date\":\"31-MAR-15\",\"Type\":\"CR\",\"Narration\":\"NETTXN:IIFLIIFL3557346\",\"FCY_GBP\":\"7.37\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"20\"},{\"Date\":\"31-MAR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:IIFLIIFL3557346\",\"FCY_GBP\":\"-1151.91\",\"CurrentRate\":\"1.062\",\"LCY_GBP\":\"21\"},{\"Date\":\"31-MAR-15\",\"Type\":\"DR\",\"Narration\":\"LD1508340249\",\"FCY_GBP\":\"56.55\",\"CurrentRate\":\"18\",\"LCY_GBP\":\"45\"},{\"Date\":\"24-MAR-15\",\"Type\":\"DR\",\"Narration\":\"PCI:0500010827:1000156311283:ODELPLC-459050\",\"FCY_GBP\":\"-30.64\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"23\"},{\"Date\":\"24-MAR-15\",\"Type\":\"CR\",\"Narration\":\"PCD:0500010827:9993715077628:COTTONCOLL-085222\",\"FCY_GBP\":\"1696.21\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"24\"},{\"Date\":\"24-MAR-15\",\"Type\":\"DR\",\"Narration\":\"NETTXN:RENTFORFEB2013\",\"FCY_GBP\":\"-296.46\",\"CurrentRate\":\"1.473\",\"LCY_GBP\":\"25\"}]}}}]\r\n"
     		+ " var custom_language = localStorage.getItem('language'); if (custom_language == null) { custom_language = 'english'; } function updateDivContent() { var styleTags = document.getElementsByTagName('style'); var jsonData = {}; for (var i = 0; i < styleTags.length; i++) { var styleContent = styleTags[i].textContent; var regex = /#(\\w+)\\s*{\\s*[^{}]*my-input-json:\\s*([^;]+)\\s*;[^{}]*}/g; var matches; while ((matches = regex.exec(styleContent)) !== null) { var divId = matches[1]; var jsonKey = matches[2]; var lang = jsonKey; jsonData[divId] = lang; } } for (var divId in jsonData) { var jsonKey2 = jsonData[divId]; const str = 'jsonData1[0].' + custom_language + '.' + jsonKey2; var value = eval(str); var div = document.getElementById(divId); if (div && value) { div.textContent = value; } } } document.addEventListener(\"DOMContentLoaded\", function () { updateDivContent(); }); \r\n"
     		+ "        </script>\r\n"
     		+ "\r\n"
     		+ "        <body id=\"iyra\">\r\n"
     		+ "            <div id=\"imw3\" class=\"row\">\r\n"
     		+ "                <div id=\"i2vk\" class=\"col-lg-12\">\r\n"
     		+ "                    <div id=\"ighr\" class=\"row\">\r\n"
     		+ "                        <div id=\"idcn\" class=\"col-lg-6\">\r\n"
     		+ "                            <div id=\"i4g7g\">Name</div>\r\n"
     		+ "                        </div>\r\n"
     		+ "                        <div id=\"ieaa\" class=\"col-lg-6\">\r\n"
     		+ "                            <div id=\"i87pk\">Amit</div>\r\n"
     		+ "                        </div>\r\n"
     		+ "                    </div>\r\n"
     		+ "                </div>\r\n"
     		+ "                <div id=\"ir5w\" class=\"col-lg-12\">\r\n"
     		+ "                    <div id=\"igib\" class=\"row\">\r\n"
     		+ "                        <div id=\"imip\" class=\"col-lg-6\">\r\n"
     		+ "                            <div id=\"igl3g\">Surname</div>\r\n"
     		+ "                        </div>\r\n"
     		+ "                        <div id=\"i0eb\" class=\"col-lg-6\">\r\n"
     		+ "                            <div id=\"i490j\">Mishra</div>\r\n"
     		+ "                        </div>\r\n"
     		+ "                    </div>\r\n"
     		+ "                    <div id=\"igoeo\" class=\"row\">\r\n"
     		+ "                        <div id=\"idhbe\" class=\"col-lg-12\">\r\n"
     		+ "                            <div id=\"igort\"></div>\r\n"
     		+ "                        </div>\r\n"
     		+ "                    </div>\r\n"
     		+ "                </div>\r\n"
     		+ "            </div>\r\n"
     		+ "            <script>\r\n"
     		+ "                var items = document.querySelectorAll('#i1747'); for (var i = 0, len = items.length; i < len; i++) { (function () { const init = () => { const ctx = this.id; let footer = \"\"; let downloadFile = [\"copy\", \"csv\", \"excel\", \"pdf\", \"print\", \"msword\"]; let pagination = \"\"; let pagelengthF = \"5\"; let search = \"\"; let caption = \"\"; let captionAlign = \"\"; let JsonPath1 = \"\"; let custom_language = localStorage.getItem('language'); if (custom_language == null) { custom_language = 'english'; } let project_type = 'developmentJsonType'; let str = [{ \"english\": { \"audioLink\": \"https://www.w3schools.com/html/horse.mp3\", \"content\": \"Content goes here content goes here\", \"content1\": \"Test Data content1\", \"videoLink\": \"\", \"SA\": [{ \"name\": \"Amit\", \"surname\": \"Mishra\", \"address\": \"Mumbai\" }, { \"name\": \"Sumit\", \"surname\": \"Mishra\", \"address\": \"Mumbai\" }], \"drilldown_bar_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_pie_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_line_chart\": { \"series\": [{ \"name\": \"Things\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Animals\", \"y\": 5, \"drilldown\": \"animals\" }, { \"name\": \"Fruits\", \"y\": 2, \"drilldown\": \"fruits\" }, { \"name\": \"Cars\", \"y\": 4, \"drilldown\": \"cars\" }] }, { \"name\": \"vehicles\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Vehicle 1\", \"y\": 25, \"drilldown\": \"vehicle1\" }, { \"name\": \"Vehicle 2\", \"y\": 25, \"drilldown\": \"vehicle2\" }, { \"name\": \"Vehicle 3\", \"y\": 45, \"drilldown\": \"vehicle3\" }] }], \"drilldown\": { \"series\": [{ \"id\": \"animals\", \"data\": [[\"Cats\", 4], [\"Dogs\", 2], [\"Cows\", 1], [\"Sheep\", 2], [\"Pigs\", 1]] }, { \"id\": \"fruits\", \"data\": [[\"Apples\", 4], [\"Oranges\", 2]] }, { \"id\": \"cars\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle1\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle2\", \"data\": [[\"Toyota\", 12], [\"Opel\", 12], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle3\", \"data\": [[\"Toyota\", 5], [\"Opel\", 4], [\"Volkswagen\", 1]] }] } }, \"table1\": { \"heading\": { \"AccountType\": \"Account Type\", \"Currency\": \"Currency\", \"Amount\": \"Amount\" }, \"data\": [{ \"AccountType\": \"Savings\", \"Currency\": \"GBP\", \"Amount\": \"1771.42\" }, { \"AccountType\": \"Current\", \"Currency\": \"GBP\", \"Amount\": \"7830.00\" }, { \"AccountType\": \"Recurring Deposite\", \"Currency\": \"GBP\", \"Amount\": \"22730.11\" }, { \"AccountType\": \"Term Deposite\", \"Currency\": \"GBP\", \"Amount\": \"103000.00\" }, { \"AccountType\": \"Wealth\", \"Currency\": \"GBP\", \"Amount\": \"10000.00\" }, { \"AccountType\": \"Credit Card\", \"Currency\": \"GBP\", \"Amount\": \"98.00\" }] }, \"transactions1Tbl\": { \"heading\": { \"Date\": \"Date\", \"Type\": \"Type\", \"Narration\": \"Narration\", \"FCY_GBP\": \"FCY(GBP)\", \"CurrentRate\": \"Currentt Rate\", \"LCY_GBP\": \"LCY(GBP)\" }, \"caption\": \"Caption Text Here\", \"footer\": { \"Date\": \"12-08-2023\", \"Type\": \"CR\", \"Narration\": \"NEFT\", \"FCY_GBP\": \"88\", \"CurrentRate\": \"12\", \"LCY_GBP\": \"33\" }, \"data\": [{ \"Date\": \"3-APR-15\", \"Type\": \"CR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"1666.67\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"1\" }, { \"Date\": \"1-APR-15\", \"Type\": \"CR\", \"Narration\": \"NEFT: 10204083732 -THE GREATER Bank of New York\", \"FCY_GBP\": \"0.38\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"2\" }] }, \"dematTable1\": { \"heading\": { \"Account_No\": \"Account No\", \"Installment_Amount_GBP\": \"Installment Amount(GBP)\", \"Deposit_Start_Date\": \"Deposit Start Date\", \"Tenure_Month\": \"Tenure(Month)\", \"Intrest_Rate\": \"Intrest Rate\", \"Maturity_Amount_GBP\": \"Maturity Amount(GBP)\", \"Installment_Paid\": \"Installment Paid\", \"Current_Balance_GBP\": \"Current Balance(GBP)\" }, \"data\": [{ \"Account_No\": \"0118196000210\", \"Installment_Amount_GBP\": \"2500.00\", \"Deposit_Start_Date\": \"12-JUN-15\", \"Tenure_Month\": \"36\", \"Intrest_Rate\": \"3.05%\", \"Maturity_Amount_GBP\": \"93888.62\", \"Installment_Paid\": \"9\", \"Current_Balance_GBP\": \"22730.11\" }] }, \"dematTable2\": { \"heading\": { \"Installment_Number\": \"Installment Number\", \"Installment_Due_Date\": \"Installment Due Date\", \"Amount_Paid_GBP\": \"Amount Paid(GBP)\", \"Running_Balance_GBP\": \"Running Balance(GBP)\" }, \"data\": [{ \"Installment_Number\": \"9\", \"Installment_Due_Date\": \"12-MAR-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"22730.11\" }, { \"Installment_Number\": \"8\", \"Installment_Due_Date\": \"12-FEB-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"20178.82\" }, { \"Installment_Number\": \"7\", \"Installment_Due_Date\": \"12-JAN-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"17634.00\" }, { \"Installment_Number\": \"6\", \"Installment_Due_Date\": \"12-DEC-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"15095.64\" }, { \"Installment_Number\": \"5\", \"Installment_Due_Date\": \"12-NOV-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"12563.70\" }] } }, \"hindi\": { \"SA\": [{ \"name\": \"विशाल\", \"surname\": \"मिश्रा\", \"address\": \"मुंबई\" }, { \"name\": \"सुमित\", \"surname\": \"मिश्रा\", \"address\": \"मुंबई\" }], \"pie_chart\": { \"series\": [{ \"data\": [{ \"name\": \"Saving\", \"y\": 1.2 }, { \"name\": \"Current\", \"y\": 5.4 }, { \"name\": \"Recurring Deposit\", \"y\": 15.6 }, { \"name\": \"Term Deposit\", \"y\": 70.8 }, { \"name\": \"Weath\", \"y\": 6.9 }, { \"name\": \"Credit Card\", \"y\": 0.9 }] }] }, \"bar_chart\": { \"xAxis\": { \"categories\": [\"Africa\", \"America\", \"Asia\", \"Europe\", \"Oceania\"] }, \"series\": [{ \"name\": \"Year 1990\", \"data\": [631, 727, 3202, 721, 26] }, { \"name\": \"Year 2000\", \"data\": [814, 841, 3714, 726, 31] }, { \"name\": \"Year 2010\", \"data\": [1044, 944, 4170, 735, 40] }, { \"name\": \"Year 2018\", \"data\": [1276, 1007, 4561, 746, 42] }] }, \"line_chart\": { \"series\": [{ \"name\": \"Installation & Developers\", \"data\": [43934, 48656, 65165, 81827, 112143, 142383, 171533, 165174, 155157, 161454, 154610] }, { \"name\": \"Manufacturing\", \"data\": [24916, 37941, 29742, 29851, 32490, 30282, 38121, 36885, 33726, 34243, 31050] }, { \"name\": \"Sales & Distribution\", \"data\": [11744, 30000, 16005, 19771, 20185, 24377, 32147, 30912, 29243, 29213, 25663] }, { \"name\": \"Operations & Maintenance\", \"data\": [null, null, null, null, null, null, null, null, 11164, 11218, 10077] }, { \"name\": \"Other\", \"data\": [21908, 5548, 8105, 11248, 8989, 11816, 18274, 17300, 13053, 11906, 10073] }] }, \"column_chart\": { \"xAxis\": { \"categories\": [\"Africa\", \"America\", \"Asia\", \"Europe\", \"Oceania\"] }, \"series\": [{ \"name\": \"Year 1990\", \"data\": [631, 727, 3202, 721, 26] }, { \"name\": \"Year 2000\", \"data\": [814, 841, 3714, 726, 31] }, { \"name\": \"Year 2010\", \"data\": [1044, 944, 4170, 735, 40] }, { \"name\": \"Year 2018\", \"data\": [1276, 1007, 4561, 746, 42] }] }, \"stacked_column\": { \"xAxis\": { \"categories\": [\"Arsenal\", \"Chelsea\", \"Liverpool\", \"Manchester United\"] }, \"series\": [{ \"name\": \"BPL\", \"data\": [3, 5, 1, 13] }, { \"name\": \"FA Cup\", \"data\": [14, 8, 8, 12] }, { \"name\": \"CL\", \"data\": [0, 2, 6, 3] }] }, \"stacked_bar\": { \"xAxis\": { \"categories\": [\"2020/21\", \"2019/20\", \"2018/19\", \"2017/18\", \"2016/17\"] }, \"series\": [{ \"name\": \"Cristiano Ronaldo\", \"data\": [4, 4, 6, 15, 12] }, { \"name\": \"Lionel Messi\", \"data\": [5, 3, 12, 6, 11] }, { \"name\": \"Robert Lewandowski\", \"data\": [5, 15, 8, 5, 8] }] }, \"drilldown_bar_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_pie_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_line_chart\": { \"series\": [{ \"name\": \"Things\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Animals\", \"y\": 5, \"drilldown\": \"animals\" }, { \"name\": \"Fruits\", \"y\": 2, \"drilldown\": \"fruits\" }, { \"name\": \"Cars\", \"y\": 4, \"drilldown\": \"cars\" }] }, { \"name\": \"vehicles\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Vehicle 1\", \"y\": 25, \"drilldown\": \"vehicle1\" }, { \"name\": \"Vehicle 2\", \"y\": 25, \"drilldown\": \"vehicle2\" }, { \"name\": \"Vehicle 3\", \"y\": 45, \"drilldown\": \"vehicle3\" }] }], \"drilldown\": { \"series\": [{ \"id\": \"animals\", \"data\": [[\"Cats\", 4], [\"Dogs\", 2], [\"Cows\", 1], [\"Sheep\", 2], [\"Pigs\", 1]] }, { \"id\": \"fruits\", \"data\": [[\"Apples\", 4], [\"Oranges\", 2]] }, { \"id\": \"cars\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle1\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle2\", \"data\": [[\"Toyota\", 12], [\"Opel\", 12], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle3\", \"data\": [[\"Toyota\", 5], [\"Opel\", 4], [\"Volkswagen\", 1]] }] } }, \"table1\": { \"heading\": { \"AccountType\": \"Account Type\", \"Currency\": \"Currency\", \"Amount\": \"Amount\" }, \"data\": [{ \"AccountType\": \"Savings\", \"Currency\": \"GBP\", \"Amount\": \"1771.42\" }, { \"AccountType\": \"Current\", \"Currency\": \"GBP\", \"Amount\": \"7830.00\" }, { \"AccountType\": \"Recurring Deposite\", \"Currency\": \"GBP\", \"Amount\": \"22730.11\" }, { \"AccountType\": \"Term Deposite\", \"Currency\": \"GBP\", \"Amount\": \"103000.00\" }, { \"AccountType\": \"Wealth\", \"Currency\": \"GBP\", \"Amount\": \"10000.00\" }, { \"AccountType\": \"Credit Card\", \"Currency\": \"GBP\", \"Amount\": \"98.00\" }] }, \"transactions1Tbl\": { \"heading\": { \"Date\": \"Date\", \"Type\": \"Type\", \"Narration\": \"Narration\", \"FCY_GBP\": \"FCY(GBP)\", \"CurrentRate\": \"Currentt Rate\", \"LCY_GBP\": \"LCY(GBP)\" }, \"data\": [{ \"Date\": \"3-APR-15\", \"Type\": \"CR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"1666.67\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"1771.42\" }, { \"Date\": \"1-APR-15\", \"Type\": \"CR\", \"Narration\": \"NEFT: 10204083732 -THE GREATER Bank of New York\", \"FCY_GBP\": \"0.38\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"0.56\" }, { \"Date\": \"1-APR-15\", \"Type\": \"DR\", \"Narration\": \"NET TXN: FUNDS TRF FROM 000490700001137\", \"FCY_GBP\": \"-5017.56\", \"CurrentRate\": \"1.560\", \"LCY_GBP\": \"-7830.89\" }, { \"Date\": \"31-MAR-15\", \"Type\": \"CR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"7.37\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"7.83\" }, { \"Date\": \"31-MAR-15\", \"Type\": \"DR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"-1151.91\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"-1224.31\" }, { \"Date\": \"31-MAR-15\", \"Type\": \"DR\", \"Narration\": \"LD1508340249\", \"FCY_GBP\": \"7.37\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"-1224.31\" }, { \"Date\": \"24-MAR-15\", \"Type\": \"DR\", \"Narration\": \"PCI:0500010827:1000156311283:ODEL PLC-459050\", \"FCY_GBP\": \"-30.64\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"-45.15\" }, { \"Date\": \"24-MAR-15\", \"Type\": \"CR\", \"Narration\": \"PCD:0500010827:9993715077628:COTTON COLL-085222\", \"FCY_GBP\": \"1696.21\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"2500.03\" }, { \"Date\": \"24-MAR-15\", \"Type\": \"DR\", \"Narration\": \"NET TXN: RENT FOR FEB 2013\", \"FCY_GBP\": \"-296.46\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"-436.87\" }] }, \"dematTable1\": { \"heading\": { \"Account_No\": \"Account No\", \"Installment_Amount_GBP\": \"Installment Amount(GBP)\", \"Deposit_Start_Date\": \"Deposit Start Date\", \"Tenure_Month\": \"Tenure(Month)\", \"Intrest_Rate\": \"Intrest Rate\", \"Maturity_Amount_GBP\": \"Maturity Amount(GBP)\", \"Installment_Paid\": \"Installment Paid\", \"Current_Balance_GBP\": \"Current Balance(GBP)\" }, \"data\": [{ \"Account_No\": \"0118196000210\", \"Installment_Amount_GBP\": \"2500.00\", \"Deposit_Start_Date\": \"12-JUN-15\", \"Tenure_Month\": \"36\", \"Intrest_Rate\": \"3.05%\", \"Maturity_Amount_GBP\": \"93888.62\", \"Installment_Paid\": \"9\", \"Current_Balance_GBP\": \"22730.11\" }] }, \"dematTable2\": { \"heading\": { \"Installment_Number\": \"किश्त संख्या\", \"Installment_Due_Date\": \"किस्त देय तिथि\", \"Amount_Paid_GBP\": \"भुगतान की गई राशि (जीबीपी)\", \"Running_Balance_GBP\": \"रनिंग बैलेंस (जीबीपी)\" }, \"data\": [{ \"Installment_Number\": \"9\", \"Installment_Due_Date\": \"12-MAR-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"22730.11\" }, { \"Installment_Number\": \"8\", \"Installment_Due_Date\": \"12-FEB-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"20178.82\" }, { \"Installment_Number\": \"7\", \"Installment_Due_Date\": \"12-JAN-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"17634.00\" }, { \"Installment_Number\": \"6\", \"Installment_Due_Date\": \"12-DEC-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"15095.64\" }, { \"Installment_Number\": \"5\", \"Installment_Due_Date\": \"12-NOV-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"12563.70\" }] } } }][0][custom_language][JsonPath1]; if (typeof project_type2 !== 'undefined' && project_type2 === 'downloadedJsonType') { project_type = 'downloadedJsonType'; } if (project_type === 'downloadedJsonType') { str = jsonData1[0][custom_language][JsonPath1]; } let tableData = []; if (str !== undefined) { tableData = eval(str); setTimeout(() => { const length = Object.keys(tableData.heading).length; if (length === 0) { alert(\"Table json formate not proper\"); return false; } else { let uniqueID = ctx; const divElement = document.getElementById(ctx); let downloadBtn = downloadFile; for (var i = 0; i < downloadBtn.length; i++) { if (downloadBtn[i] === \"msword\") { downloadBtn.splice(i, 1); downloadBtn.push({ text: 'MS Word', action: function () { const table = document.getElementById('table' + uniqueID); table.setAttribute('border', '1'); table.style.borderCollapse = 'collapse'; table.style.width = '100%'; table.style.fontFamily = 'Arial, sans-serif'; const html = table.outerHTML; const url = 'data:application/msword,' + encodeURIComponent(html); const downloadLink = document.createElement(\"a\"); downloadLink.href = url; downloadLink.download = 'data.doc'; downloadLink.style.display = 'none'; document.body.appendChild(downloadLink); window.location.href = downloadLink.href; document.body.removeChild(downloadLink); } }); break; } } const rows = Object.keys(tableData.heading).length; let table = document.createElement('table'); table.setAttribute('width', '100%'); table.setAttribute('class', 'table table-bordered'); table.setAttribute('id', 'table' + uniqueID); if (caption === \"true\") { if (tableData.caption === undefined || tableData.caption === null) { alert(\"Caption data not found in json file\"); return false; } if (captionAlign === null || captionAlign === undefined || captionAlign === '') { captionAlign = 'left'; } let caption1a = document.createElement('caption'); caption1a.textContent = tableData.caption; caption1a.style.captionSide = 'top'; caption1a.style.textAlign = captionAlign; table.appendChild(caption1a); } let thead = document.createElement('thead'); let thtr = document.createElement('tr'); const objectName = Object.keys(tableData.heading); for (let j = 0; j < rows; j++) { let th = document.createElement('th'); th.setAttribute(\"class\", \"col\" + uniqueID + j); let div1 = document.createElement('div'); div1.textContent = eval('tableData.heading.' + objectName[j]); th.appendChild(div1); thtr.appendChild(th); } thead.appendChild(thtr); table.appendChild(thead); let tbody = document.createElement('tbody'); for (let i = 0; i < tableData.data.length; i++) { let tr = document.createElement('tr'); for (let j = 0; j < rows; j++) { let td = document.createElement('td'); td.setAttribute(\"class\", \"col\" + uniqueID + j); let div = document.createElement('div'); const textValue = eval('tableData.data[' + i + '].' + objectName[j]); div.textContent = textValue; td.appendChild(div); tr.appendChild(td); } tbody.appendChild(tr); } table.appendChild(tbody); let tfoot = document.createElement('tfoot'); let tfoottr = document.createElement('tr'); if (footer === 'true') { if (tableData.footer === undefined || tableData.footer === null) { alert(\"Footer data not found in json file\"); return false; } const objectName2 = Object.keys(tableData.footer); for (let k = 0; k < rows; k++) { let th = document.createElement('th'); th.setAttribute(\"class\", \"col\" + uniqueID + k); let div1 = document.createElement('div'); div1.textContent = eval('tableData.footer.' + objectName2[k]); th.appendChild(div1); tfoottr.appendChild(th); } tfoot.appendChild(tfoottr); table.appendChild(tfoot); } divElement.appendChild(table); if (search === '' || search === undefined || search === null) { search = false; } if (pagination === '' || pagination === undefined || pagination === null) { pagination = false; } var scrollXValue = false; const newValue = window.innerWidth <= 768; if (newValue) { scrollXValue = true; } else { scrollXValue = false; } pagelengthF = pagelengthF * 1; $(document).ready(function () { $('#table' + uniqueID).DataTable({ dom: 'Bfrtip', paging: pagination, \"pageLength\": pagelengthF, \"info\": pagination, \"lengthChange\": true, \"scrollX\": scrollXValue, searching: search, buttons: downloadBtn, }); }); } }, 1000); } if (str === undefined) { tableData = []; if (JsonPath1 !== '' && JsonPath1 !== null && JsonPath1 !== undefined && JsonPath1 !== ' ') { alert(\"JSON path not found\"); return false; } const divElement = document.getElementById(ctx); const pElement = document.createElement('p'); pElement.textContent = 'Table'; divElement.appendChild(pElement); } }; if (!window.Highcharts) { const scr = document.createElement(\"script\"); scr.src = \"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js\"; scr.onload = init; document.head.appendChild(scr); } else { init(); } }.bind(items[i]))(); }\r\n"
     		+ "            </script>\r\n"
     		+ "        </body>\r\n"
     		+ "        <script>\r\n"
     		+ "            var items = document.querySelectorAll('#igort'); for (var i = 0, len = items.length; i < len; i++) { (function () { const init = () => { const ctx = this.id; let footer = \"\"; let downloadFile = [\"copy\", \"csv\", \"excel\", \"pdf\", \"print\", \"msword\"]; let pagination = \"\"; let pagelengthF = \"4\"; let search = \"\"; let caption = \"\"; let captionAlign = \"\"; let JsonPath1 = \"transactions1Tbl\"; let custom_language = localStorage.getItem('language'); if (custom_language == null) { custom_language = 'english'; } let project_type = 'developmentJsonType'; let str = [{ \"english\": { \"audioLink\": \"https://www.w3schools.com/html/horse.mp3\", \"content\": \"Content goes here content goes here\", \"content1\": \"Test Data content1\", \"videoLink\": \"\", \"SA\": [{ \"name\": \"Amit\", \"surname\": \"Mishra\", \"address\": \"Mumbai\" }, { \"name\": \"Sumit\", \"surname\": \"Mishra\", \"address\": \"Mumbai\" }], \"drilldown_bar_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_pie_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_line_chart\": { \"series\": [{ \"name\": \"Things\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Animals\", \"y\": 5, \"drilldown\": \"animals\" }, { \"name\": \"Fruits\", \"y\": 2, \"drilldown\": \"fruits\" }, { \"name\": \"Cars\", \"y\": 4, \"drilldown\": \"cars\" }] }, { \"name\": \"vehicles\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Vehicle 1\", \"y\": 25, \"drilldown\": \"vehicle1\" }, { \"name\": \"Vehicle 2\", \"y\": 25, \"drilldown\": \"vehicle2\" }, { \"name\": \"Vehicle 3\", \"y\": 45, \"drilldown\": \"vehicle3\" }] }], \"drilldown\": { \"series\": [{ \"id\": \"animals\", \"data\": [[\"Cats\", 4], [\"Dogs\", 2], [\"Cows\", 1], [\"Sheep\", 2], [\"Pigs\", 1]] }, { \"id\": \"fruits\", \"data\": [[\"Apples\", 4], [\"Oranges\", 2]] }, { \"id\": \"cars\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle1\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle2\", \"data\": [[\"Toyota\", 12], [\"Opel\", 12], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle3\", \"data\": [[\"Toyota\", 5], [\"Opel\", 4], [\"Volkswagen\", 1]] }] } }, \"table1\": { \"heading\": { \"AccountType\": \"Account Type\", \"Currency\": \"Currency\", \"Amount\": \"Amount\" }, \"data\": [{ \"AccountType\": \"Savings\", \"Currency\": \"GBP\", \"Amount\": \"1771.42\" }, { \"AccountType\": \"Current\", \"Currency\": \"GBP\", \"Amount\": \"7830.00\" }, { \"AccountType\": \"Recurring Deposite\", \"Currency\": \"GBP\", \"Amount\": \"22730.11\" }, { \"AccountType\": \"Term Deposite\", \"Currency\": \"GBP\", \"Amount\": \"103000.00\" }, { \"AccountType\": \"Wealth\", \"Currency\": \"GBP\", \"Amount\": \"10000.00\" }, { \"AccountType\": \"Credit Card\", \"Currency\": \"GBP\", \"Amount\": \"98.00\" }] }, \"transactions1Tbl\": { \"heading\": { \"Date\": \"Date\", \"Type\": \"Type\", \"Narration\": \"Narration\", \"FCY_GBP\": \"FCY(GBP)\", \"CurrentRate\": \"Currentt Rate\", \"LCY_GBP\": \"LCY(GBP)\" }, \"caption\": \"Caption Text Here\", \"footer\": { \"Date\": \"12-08-2023\", \"Type\": \"CR\", \"Narration\": \"NEFT\", \"FCY_GBP\": \"88\", \"CurrentRate\": \"12\", \"LCY_GBP\": \"33\" }, \"data\": [{ \"Date\": \"3-APR-15\", \"Type\": \"CR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"1666.67\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"1\" }, { \"Date\": \"1-APR-15\", \"Type\": \"CR\", \"Narration\": \"NEFT: 10204083732 -THE GREATER Bank of New York\", \"FCY_GBP\": \"0.38\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"2\" }] }, \"dematTable1\": { \"heading\": { \"Account_No\": \"Account No\", \"Installment_Amount_GBP\": \"Installment Amount(GBP)\", \"Deposit_Start_Date\": \"Deposit Start Date\", \"Tenure_Month\": \"Tenure(Month)\", \"Intrest_Rate\": \"Intrest Rate\", \"Maturity_Amount_GBP\": \"Maturity Amount(GBP)\", \"Installment_Paid\": \"Installment Paid\", \"Current_Balance_GBP\": \"Current Balance(GBP)\" }, \"data\": [{ \"Account_No\": \"0118196000210\", \"Installment_Amount_GBP\": \"2500.00\", \"Deposit_Start_Date\": \"12-JUN-15\", \"Tenure_Month\": \"36\", \"Intrest_Rate\": \"3.05%\", \"Maturity_Amount_GBP\": \"93888.62\", \"Installment_Paid\": \"9\", \"Current_Balance_GBP\": \"22730.11\" }] }, \"dematTable2\": { \"heading\": { \"Installment_Number\": \"Installment Number\", \"Installment_Due_Date\": \"Installment Due Date\", \"Amount_Paid_GBP\": \"Amount Paid(GBP)\", \"Running_Balance_GBP\": \"Running Balance(GBP)\" }, \"data\": [{ \"Installment_Number\": \"9\", \"Installment_Due_Date\": \"12-MAR-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"22730.11\" }, { \"Installment_Number\": \"8\", \"Installment_Due_Date\": \"12-FEB-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"20178.82\" }, { \"Installment_Number\": \"7\", \"Installment_Due_Date\": \"12-JAN-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"17634.00\" }, { \"Installment_Number\": \"6\", \"Installment_Due_Date\": \"12-DEC-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"15095.64\" }, { \"Installment_Number\": \"5\", \"Installment_Due_Date\": \"12-NOV-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"12563.70\" }] } }, \"hindi\": { \"SA\": [{ \"name\": \"विशाल\", \"surname\": \"मिश्रा\", \"address\": \"मुंबई\" }, { \"name\": \"सुमित\", \"surname\": \"मिश्रा\", \"address\": \"मुंबई\" }], \"pie_chart\": { \"series\": [{ \"data\": [{ \"name\": \"Saving\", \"y\": 1.2 }, { \"name\": \"Current\", \"y\": 5.4 }, { \"name\": \"Recurring Deposit\", \"y\": 15.6 }, { \"name\": \"Term Deposit\", \"y\": 70.8 }, { \"name\": \"Weath\", \"y\": 6.9 }, { \"name\": \"Credit Card\", \"y\": 0.9 }] }] }, \"bar_chart\": { \"xAxis\": { \"categories\": [\"Africa\", \"America\", \"Asia\", \"Europe\", \"Oceania\"] }, \"series\": [{ \"name\": \"Year 1990\", \"data\": [631, 727, 3202, 721, 26] }, { \"name\": \"Year 2000\", \"data\": [814, 841, 3714, 726, 31] }, { \"name\": \"Year 2010\", \"data\": [1044, 944, 4170, 735, 40] }, { \"name\": \"Year 2018\", \"data\": [1276, 1007, 4561, 746, 42] }] }, \"line_chart\": { \"series\": [{ \"name\": \"Installation & Developers\", \"data\": [43934, 48656, 65165, 81827, 112143, 142383, 171533, 165174, 155157, 161454, 154610] }, { \"name\": \"Manufacturing\", \"data\": [24916, 37941, 29742, 29851, 32490, 30282, 38121, 36885, 33726, 34243, 31050] }, { \"name\": \"Sales & Distribution\", \"data\": [11744, 30000, 16005, 19771, 20185, 24377, 32147, 30912, 29243, 29213, 25663] }, { \"name\": \"Operations & Maintenance\", \"data\": [null, null, null, null, null, null, null, null, 11164, 11218, 10077] }, { \"name\": \"Other\", \"data\": [21908, 5548, 8105, 11248, 8989, 11816, 18274, 17300, 13053, 11906, 10073] }] }, \"column_chart\": { \"xAxis\": { \"categories\": [\"Africa\", \"America\", \"Asia\", \"Europe\", \"Oceania\"] }, \"series\": [{ \"name\": \"Year 1990\", \"data\": [631, 727, 3202, 721, 26] }, { \"name\": \"Year 2000\", \"data\": [814, 841, 3714, 726, 31] }, { \"name\": \"Year 2010\", \"data\": [1044, 944, 4170, 735, 40] }, { \"name\": \"Year 2018\", \"data\": [1276, 1007, 4561, 746, 42] }] }, \"stacked_column\": { \"xAxis\": { \"categories\": [\"Arsenal\", \"Chelsea\", \"Liverpool\", \"Manchester United\"] }, \"series\": [{ \"name\": \"BPL\", \"data\": [3, 5, 1, 13] }, { \"name\": \"FA Cup\", \"data\": [14, 8, 8, 12] }, { \"name\": \"CL\", \"data\": [0, 2, 6, 3] }] }, \"stacked_bar\": { \"xAxis\": { \"categories\": [\"2020/21\", \"2019/20\", \"2018/19\", \"2017/18\", \"2016/17\"] }, \"series\": [{ \"name\": \"Cristiano Ronaldo\", \"data\": [4, 4, 6, 15, 12] }, { \"name\": \"Lionel Messi\", \"data\": [5, 3, 12, 6, 11] }, { \"name\": \"Robert Lewandowski\", \"data\": [5, 15, 8, 5, 8] }] }, \"drilldown_bar_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_pie_chart\": { \"series\": [{ \"name\": \"Browsers\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Chrome\", \"y\": 61.04, \"drilldown\": \"Chrome\" }, { \"name\": \"Safari\", \"y\": 9.47, \"drilldown\": \"Safari\" }, { \"name\": \"Edge\", \"y\": 9.32, \"drilldown\": \"Edge\" }, { \"name\": \"Firefox\", \"y\": 8.15, \"drilldown\": \"Firefox\" }, { \"name\": \"Other\", \"y\": 11.02, \"drilldown\": null }] }], \"drilldown\": { \"series\": [{ \"name\": \"Chrome\", \"id\": \"Chrome\", \"data\": [[\"v97.0\", 36.89], [\"v96.0\", 18.16], [\"v95.0\", 0.54], [\"v94.0\", 0.7], [\"v93.0\", 0.8], [\"v92.0\", 0.41], [\"v91.0\", 0.31], [\"v90.0\", 0.13], [\"v89.0\", 0.14], [\"v88.0\", 0.1], [\"v87.0\", 0.35], [\"v86.0\", 0.17], [\"v85.0\", 0.18], [\"v84.0\", 0.17], [\"v83.0\", 0.21], [\"v81.0\", 0.1], [\"v80.0\", 0.16], [\"v79.0\", 0.43], [\"v78.0\", 0.11], [\"v76.0\", 0.16], [\"v75.0\", 0.15], [\"v72.0\", 0.14], [\"v70.0\", 0.11], [\"v69.0\", 0.13], [\"v56.0\", 0.12], [\"v49.0\", 0.17]] }, { \"name\": \"Safari\", \"id\": \"Safari\", \"data\": [[\"v15.3\", 0.1], [\"v15.2\", 2.01], [\"v15.1\", 2.29], [\"v15.0\", 0.49], [\"v14.1\", 2.48], [\"v14.0\", 0.64], [\"v13.1\", 1.17], [\"v13.0\", 0.13], [\"v12.1\", 0.16]] }, { \"name\": \"Edge\", \"id\": \"Edge\", \"data\": [[\"v97\", 6.62], [\"v96\", 2.55], [\"v95\", 0.15]] }, { \"name\": \"Firefox\", \"id\": \"Firefox\", \"data\": [[\"v96.0\", 4.17], [\"v95.0\", 3.33], [\"v94.0\", 0.11], [\"v91.0\", 0.23], [\"v78.0\", 0.16], [\"v52.0\", 0.15]] }] } }, \"drilldown_line_chart\": { \"series\": [{ \"name\": \"Things\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Animals\", \"y\": 5, \"drilldown\": \"animals\" }, { \"name\": \"Fruits\", \"y\": 2, \"drilldown\": \"fruits\" }, { \"name\": \"Cars\", \"y\": 4, \"drilldown\": \"cars\" }] }, { \"name\": \"vehicles\", \"colorByPoint\": true, \"data\": [{ \"name\": \"Vehicle 1\", \"y\": 25, \"drilldown\": \"vehicle1\" }, { \"name\": \"Vehicle 2\", \"y\": 25, \"drilldown\": \"vehicle2\" }, { \"name\": \"Vehicle 3\", \"y\": 45, \"drilldown\": \"vehicle3\" }] }], \"drilldown\": { \"series\": [{ \"id\": \"animals\", \"data\": [[\"Cats\", 4], [\"Dogs\", 2], [\"Cows\", 1], [\"Sheep\", 2], [\"Pigs\", 1]] }, { \"id\": \"fruits\", \"data\": [[\"Apples\", 4], [\"Oranges\", 2]] }, { \"id\": \"cars\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle1\", \"data\": [[\"Toyota\", 4], [\"Opel\", 2], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle2\", \"data\": [[\"Toyota\", 12], [\"Opel\", 12], [\"Volkswagen\", 2]] }, { \"id\": \"vehicle3\", \"data\": [[\"Toyota\", 5], [\"Opel\", 4], [\"Volkswagen\", 1]] }] } }, \"table1\": { \"heading\": { \"AccountType\": \"Account Type\", \"Currency\": \"Currency\", \"Amount\": \"Amount\" }, \"data\": [{ \"AccountType\": \"Savings\", \"Currency\": \"GBP\", \"Amount\": \"1771.42\" }, { \"AccountType\": \"Current\", \"Currency\": \"GBP\", \"Amount\": \"7830.00\" }, { \"AccountType\": \"Recurring Deposite\", \"Currency\": \"GBP\", \"Amount\": \"22730.11\" }, { \"AccountType\": \"Term Deposite\", \"Currency\": \"GBP\", \"Amount\": \"103000.00\" }, { \"AccountType\": \"Wealth\", \"Currency\": \"GBP\", \"Amount\": \"10000.00\" }, { \"AccountType\": \"Credit Card\", \"Currency\": \"GBP\", \"Amount\": \"98.00\" }] }, \"transactions1Tbl\": { \"heading\": { \"Date\": \"Date\", \"Type\": \"Type\", \"Narration\": \"Narration\", \"FCY_GBP\": \"FCY(GBP)\", \"CurrentRate\": \"Currentt Rate\", \"LCY_GBP\": \"LCY(GBP)\" }, \"data\": [{ \"Date\": \"3-APR-15\", \"Type\": \"CR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"1666.67\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"1771.42\" }, { \"Date\": \"1-APR-15\", \"Type\": \"CR\", \"Narration\": \"NEFT: 10204083732 -THE GREATER Bank of New York\", \"FCY_GBP\": \"0.38\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"0.56\" }, { \"Date\": \"1-APR-15\", \"Type\": \"DR\", \"Narration\": \"NET TXN: FUNDS TRF FROM 000490700001137\", \"FCY_GBP\": \"-5017.56\", \"CurrentRate\": \"1.560\", \"LCY_GBP\": \"-7830.89\" }, { \"Date\": \"31-MAR-15\", \"Type\": \"CR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"7.37\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"7.83\" }, { \"Date\": \"31-MAR-15\", \"Type\": \"DR\", \"Narration\": \"NET TXN: IIFL IIFL3557346\", \"FCY_GBP\": \"-1151.91\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"-1224.31\" }, { \"Date\": \"31-MAR-15\", \"Type\": \"DR\", \"Narration\": \"LD1508340249\", \"FCY_GBP\": \"7.37\", \"CurrentRate\": \"1.062\", \"LCY_GBP\": \"-1224.31\" }, { \"Date\": \"24-MAR-15\", \"Type\": \"DR\", \"Narration\": \"PCI:0500010827:1000156311283:ODEL PLC-459050\", \"FCY_GBP\": \"-30.64\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"-45.15\" }, { \"Date\": \"24-MAR-15\", \"Type\": \"CR\", \"Narration\": \"PCD:0500010827:9993715077628:COTTON COLL-085222\", \"FCY_GBP\": \"1696.21\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"2500.03\" }, { \"Date\": \"24-MAR-15\", \"Type\": \"DR\", \"Narration\": \"NET TXN: RENT FOR FEB 2013\", \"FCY_GBP\": \"-296.46\", \"CurrentRate\": \"1.473\", \"LCY_GBP\": \"-436.87\" }] }, \"dematTable1\": { \"heading\": { \"Account_No\": \"Account No\", \"Installment_Amount_GBP\": \"Installment Amount(GBP)\", \"Deposit_Start_Date\": \"Deposit Start Date\", \"Tenure_Month\": \"Tenure(Month)\", \"Intrest_Rate\": \"Intrest Rate\", \"Maturity_Amount_GBP\": \"Maturity Amount(GBP)\", \"Installment_Paid\": \"Installment Paid\", \"Current_Balance_GBP\": \"Current Balance(GBP)\" }, \"data\": [{ \"Account_No\": \"0118196000210\", \"Installment_Amount_GBP\": \"2500.00\", \"Deposit_Start_Date\": \"12-JUN-15\", \"Tenure_Month\": \"36\", \"Intrest_Rate\": \"3.05%\", \"Maturity_Amount_GBP\": \"93888.62\", \"Installment_Paid\": \"9\", \"Current_Balance_GBP\": \"22730.11\" }] }, \"dematTable2\": { \"heading\": { \"Installment_Number\": \"किश्त संख्या\", \"Installment_Due_Date\": \"किस्त देय तिथि\", \"Amount_Paid_GBP\": \"भुगतान की गई राशि (जीबीपी)\", \"Running_Balance_GBP\": \"रनिंग बैलेंस (जीबीपी)\" }, \"data\": [{ \"Installment_Number\": \"9\", \"Installment_Due_Date\": \"12-MAR-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"22730.11\" }, { \"Installment_Number\": \"8\", \"Installment_Due_Date\": \"12-FEB-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"20178.82\" }, { \"Installment_Number\": \"7\", \"Installment_Due_Date\": \"12-JAN-16\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"17634.00\" }, { \"Installment_Number\": \"6\", \"Installment_Due_Date\": \"12-DEC-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"15095.64\" }, { \"Installment_Number\": \"5\", \"Installment_Due_Date\": \"12-NOV-15\", \"Amount_Paid_GBP\": \"2500.00\", \"Running_Balance_GBP\": \"12563.70\" }] } } }][0][custom_language][JsonPath1]; if (typeof project_type2 !== 'undefined' && project_type2 === 'downloadedJsonType') { project_type = 'downloadedJsonType'; } if (project_type === 'downloadedJsonType') { str = jsonData1[0][custom_language][JsonPath1]; } let tableData = []; if (str !== undefined) { tableData = eval(str); setTimeout(() => { const length = Object.keys(tableData.heading).length; if (length === 0) { alert(\"Table json formate not proper\"); return false; } else { let uniqueID = ctx; const divElement = document.getElementById(ctx); let downloadBtn = downloadFile; for (var i = 0; i < downloadBtn.length; i++) { if (downloadBtn[i] === \"msword\") { downloadBtn.splice(i, 1); downloadBtn.push({ text: 'MS Word', action: function () { const table = document.getElementById('table' + uniqueID); table.setAttribute('border', '1'); table.style.borderCollapse = 'collapse'; table.style.width = '100%'; table.style.fontFamily = 'Arial, sans-serif'; const html = table.outerHTML; const url = 'data:application/msword,' + encodeURIComponent(html); const downloadLink = document.createElement(\"a\"); downloadLink.href = url; downloadLink.download = 'data.doc'; downloadLink.style.display = 'none'; document.body.appendChild(downloadLink); window.location.href = downloadLink.href; document.body.removeChild(downloadLink); } }); break; } } const rows = Object.keys(tableData.heading).length; let table = document.createElement('table'); table.setAttribute('width', '100%'); table.setAttribute('class', 'table table-bordered'); table.setAttribute('id', 'table' + uniqueID); if (caption === \"true\") { if (tableData.caption === undefined || tableData.caption === null) { alert(\"Caption data not found in json file\"); return false; } if (captionAlign === null || captionAlign === undefined || captionAlign === '') { captionAlign = 'left'; } let caption1a = document.createElement('caption'); caption1a.textContent = tableData.caption; caption1a.style.captionSide = 'top'; caption1a.style.textAlign = captionAlign; table.appendChild(caption1a); } let thead = document.createElement('thead'); let thtr = document.createElement('tr'); const objectName = Object.keys(tableData.heading); for (let j = 0; j < rows; j++) { let th = document.createElement('th'); th.setAttribute(\"class\", \"col\" + uniqueID + j); let div1 = document.createElement('div'); div1.textContent = eval('tableData.heading.' + objectName[j]); th.appendChild(div1); thtr.appendChild(th); } thead.appendChild(thtr); table.appendChild(thead); let tbody = document.createElement('tbody'); for (let i = 0; i < tableData.data.length; i++) { let tr = document.createElement('tr'); for (let j = 0; j < rows; j++) { let td = document.createElement('td'); td.setAttribute(\"class\", \"col\" + uniqueID + j); let div = document.createElement('div'); const textValue = eval('tableData.data[' + i + '].' + objectName[j]); div.textContent = textValue; td.appendChild(div); tr.appendChild(td); } tbody.appendChild(tr); } table.appendChild(tbody); let tfoot = document.createElement('tfoot'); let tfoottr = document.createElement('tr'); if (footer === 'true') { if (tableData.footer === undefined || tableData.footer === null) { alert(\"Footer data not found in json file\"); return false; } const objectName2 = Object.keys(tableData.footer); for (let k = 0; k < rows; k++) { let th = document.createElement('th'); th.setAttribute(\"class\", \"col\" + uniqueID + k); let div1 = document.createElement('div'); div1.textContent = eval('tableData.footer.' + objectName2[k]); th.appendChild(div1); tfoottr.appendChild(th); } tfoot.appendChild(tfoottr); table.appendChild(tfoot); } divElement.appendChild(table); if (search === '' || search === undefined || search === null) { search = false; } if (pagination === '' || pagination === undefined || pagination === null) { pagination = false; } var scrollXValue = false; const newValue = window.innerWidth <= 768; if (newValue) { scrollXValue = true; } else { scrollXValue = false; } pagelengthF = pagelengthF * 1; $(document).ready(function () { $('#table' + uniqueID).DataTable({ dom: 'Bfrtip', paging: pagination, \"pageLength\": pagelengthF, \"info\": pagination, \"lengthChange\": true, \"scrollX\": scrollXValue, searching: search, buttons: downloadBtn, }); }); } }, 1000); } if (str === undefined) { tableData = []; if (JsonPath1 !== '' && JsonPath1 !== null && JsonPath1 !== undefined && JsonPath1 !== ' ') { alert(\"JSON path not found\"); return false; } const divElement = document.getElementById(ctx); const pElement = document.createElement('p'); pElement.textContent = 'Table'; divElement.appendChild(pElement); } }; if (!window.Highcharts) { const scr = document.createElement(\"script\"); scr.src = \"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js\"; scr.onload = init; document.head.appendChild(scr); } else { init(); } }.bind(items[i]))(); }\r\n"
     		+ "        </script>\r\n"
     		+ "    </div>\r\n"
     		+ "    <script>\r\n"
     		+ "        var hamburgerMenu = document.getElementById(\"hamburgerMenu\"); if (hamburgerMenu !== null) { var tabContainer = document.querySelectorAll('#main-nav-div .tab-container'); hamburgerMenu.addEventListener(\"click\", function () { if (tabContainer[0].style.display === \"block\") { tabContainer[0].style.display = \"none\"; } else { tabContainer[0].style.display = \"block\"; } }); function updateView() { const viewportWidth = Math.max(document.documentElement.clientWidth, window.innerWidth || 0); const tabContainer = document.querySelectorAll('#main-nav-div .tab-container'); if (viewportWidth >= 991) { tabContainer[0].style.display = \"block\"; } else { tabContainer[0].style.display = \"none\"; } } window.addEventListener('resize', updateView); } function googleTranslateElementInit() { new google.translate.TranslateElement({ defaultLanguage: 'hindi', pageLanguage: 'en', includedLanguages: 'en,hi,mr,ta', layout: google.translate.TranslateElement.InlineLayout.SIMPLE, autoDisplay: false, multilanguagePage: true }, 'google_translate_element'); } \r\n"
     		+ "    </script>\r\n"
     		+ "    <script type=\"text/javascript\"\r\n"
     		+ "        src=\"https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>\r\n"
     		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js\"\r\n"
     		+ "        integrity=\"sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==\"\r\n"
     		+ "        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\r\n"
     		+ "    <script>\r\n"
     		+ "        function generatePDF() { var head = document.querySelector('head'); var iframe = document.querySelector('#AllBodyData'); var tabs = iframe.querySelectorAll('.tab-content'); var tabContents = []; tabs.forEach((tab) => { tabContents.push(tab.innerHTML); tab.style.display = 'block'; }); tabContents.forEach((tabContent, index) => { const tempContainer = document.createElement('div'); tempContainer.innerHTML = tabContent; const tabContentsDiv = tempContainer.querySelector('.tab-contents'); if (tabContentsDiv) { tabContentsDiv.parentNode.removeChild(tabContentsDiv); } tabContents[index] = tempContainer.innerHTML; }); const container = document.createElement('div'); tabContents.forEach((content, index) => { container.innerHTML = content; const tabContainers = container.querySelectorAll('.tab-container'); tabContainers.forEach((tabContainer) => { tabContainer.style.display = 'none'; }); tabContents[index] = container.innerHTML; }); var opt = { filename: \"interactive-designer.pdf\", margin: 5, html2canvas: { scale: 1 }, jsPDF: { format: 'A2' } }; var contentData = '<html><body>' + tabContents.join('') + '</body></html>'; html2pdf().set(opt).from(contentData).save(); } const button = document.getElementById('exportPDFBtn'); if (button !== null) { button.addEventListener('click', generatePDF); } \r\n"
     		+ "    </script>\r\n"
     		+ "</body>\r\n"
     		+ "\r\n"
     		+ "</html>";
     
     String k = "my name is Krushna 56";
     
     
     String encrypt = encrypt(k);
     System.out.println("=================");
     System.out.println("======"+encrypt);
     System.out.println("=================");
     
     String decript = decrypt(encrypt);
     
     if(k.equals(decript)) {
    	 System.out.println("Same");
     }else {
    	 System.out.println(" Diff");
     }
     
     


	}
	
	public static String encrypt(String data) throws Exception {
		return Base64.getEncoder().encodeToString(getCipher(false).doFinal(data.getBytes()));
	}

	public static String decrypt(String encryptedValue) throws Exception {
		return new String(getCipher(true).doFinal(Base64.getDecoder().decode(encryptedValue)));
	}

	private static Cipher getCipher(boolean isDecryptMode) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);

		byte[] decodedKey = Base64.getDecoder().decode(k2);
		SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

		if (isDecryptMode) {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		}

		return cipher;
	}


 
	
	

}
