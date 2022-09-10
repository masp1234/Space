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
        'https://simple-books-api.glitch.me/books',

        {
            method: 'GET'
            
        }
    
    
        )
        const data = await response.json();
        showfetch.innerHTML = data;
};