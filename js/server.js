const express= require("express")
const csvRoutes=require("./routers/csvRoutes")
const server=express()

server.use("/api/csv",csvRoutes)

server.listen(8080,()=>{
    console.log("listening on 8080")
})