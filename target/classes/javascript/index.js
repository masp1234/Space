
importData();

async function importData() {
    const response = await fetch('https://api.wheretheiss.at/v1/satellites/25544');


        const data = await response.json();
        console.log(data);
        showfetch.innerHTML = data.name;

        const h2 = document.querySelector('#showfetch')
        h2.innerHTML = data.name;
};