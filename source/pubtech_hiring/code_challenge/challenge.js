const pages = require("./data.json");

/*
    CHALLENGE:
    Using this function as a mock api call, fetch pages
    and transform them into a publication. Publication should contain a
    sorted list of editions.  Each edition contains a sorted list of pages.
*/
const fetchPages = async () => {
    return await new Promise((resolve, reject) => {
            setTimeout(() => {
                const success = Math.random() < 0.75;
                if (success) {
                    resolve({status: 200, pages})
                } else {
                    reject({status: 404, message: 'error: not found'})
                }
            }, 1000)
      });
}
