importData();

async function importData() {
    const response = await fetch('https://api.wheretheiss.at/v1/satellites/25544');


        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        console.log(data);

        const h2 = document.querySelector('#showfetch')
        h2.innerHTML = data.name;
};

$(document).ready(function () {
    $('#showfetch').click(function () {
        $('#showfetch').hide();
    });

    $('#showfetch').mouseenter(function() {
        $('#showfetch').hide();
        console.log("entered");
    });

    $('#showfetch').mouseleave(function() {
        $('#showfetch').show();
        console.log("left");
    })
});


