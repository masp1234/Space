

async function importData() {
    getISSLocation();
    getSpaceXLaunches();
    
};

$(document).ready(function () {
    importData();

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

async function getISSLocation() {
    const response = await fetch('https://api.wheretheiss.at/v1/satellites/25544');


        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const issLocation = await response.json();
        console.log(issLocation);

        const issLocationElement = document.querySelector('#showfetch')
        issLocationElement.innerHTML = issLocation.name;
}

async function getSpaceXLaunches() {
    const response = await fetch('https://api.spacexdata.com/v2/launches');

    if(!response.ok) {
        throw new Error(`Error: could not fetch. Status: ${response.status}`);
    }

    const spaceXLaunches = await response.json();
    console.log(spaceXLaunches);
    
    const spaceXLaunchesElement = document.querySelector('#spaceXLaunches');
    spaceXLaunchesElement.innerHTML = spaceXLaunches[0].mission_name;

}

