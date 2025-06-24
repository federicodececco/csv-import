const fs = require("fs");
const parse = require("csv-parser");

const csvManager = () => {
  return new Promise((resolve, reject) => {
    let products = [];
    fs.createReadStream("products.csv")
      .pipe(parse())
      .on("data", (row) => {
        products.push(row);
      })
      .on("end", () => {
        resolve(products);
      })
      .on("error", (error) => {
        reject(error);
      });
  });
};

module.exports = csvManager;
