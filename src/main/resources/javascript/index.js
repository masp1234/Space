const showfetch = document.querySelector("#showfetch");



$(document).ready(function(){
    importData();
    $("#hello").click(function() {
        $("#hello").hide();
    }
    
    )
}
);

async function importData() {
    const response = await fetch(
        'https://api.nasa.gov/planetary/apod?api_key=0xBWwWrQ3fosBO3mfognfipbqRDMeWUQb40DxwcS&start_date=2022-05-28',

        {
            method: 'GET'
            
        }
    
    
        )
        const data = await response.json();
        showfetch.innerHTML = data;
};