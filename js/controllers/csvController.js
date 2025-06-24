const connection = require("../data");
const csvManager = require("../csvManager");
const upload = async (req, res) => {
  try {
    const csvArr = await csvManager();
    csvArr.forEach((elem) => {
      elem.price = elem.price != null ? elem.price : 0.0;
      console.log(elem);
    });
    res.send("File elaborato con successo");
  } catch (error) {
    console.error("Errore durante l'elaborazione del CSV:", error);
    res.status(500).send("Errore nel processamento del file");
  }
};
module.exports = { upload };
