const express = require('express');
const router = express.Router();
//const { getUsers,createUsers,userDetail,deleteUser,updateUser } = require ("../controllers/users.js")
const locationControllerC = require("../../controllers/v1/locationController.js")
const locationController = new locationControllerC();

router.get('/', locationController.listlocation);
router.post('/uploadHtml', locationController.uploadHTML);
router.post('/uploadHtml2', locationController.uploadHTML2);
// router.post('/uploadHtmlToRtf', locationController.uploadHtmlToRtf);
router.post('/uploadHtmlSinglePage', locationController.uploadHtmlSinglePage);


module.exports = router;