const express = require("express")
const router=express.Router()
const  csvController= require("../controllers/csvController")
router.post("/upload",csvController.upload)
module.exports=router