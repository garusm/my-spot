const f = document.getElementById('form');
const q = document.getElementById('query');
const mySpot = '/spotify/tracks/';

function submitted(event) {
    event.preventDefault();
    const url = mySpot + q.value;
    const win = window.open(url, "_self");
    win.focus();
}
f.addEventListener('submit', submitted);