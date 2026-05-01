/**
 * 
 */

let totalSeconds = 5 * 3600 + 58 * 60 + 25;

function updateTimer() {
    let hours = Math.floor(totalSeconds / 3600);
    let minutes = Math.floor((totalSeconds % 3600) / 60);
    let seconds = totalSeconds % 60;

    document.getElementById("hours").innerText = String(hours).padStart(2, '0');
    document.getElementById("minutes").innerText = String(minutes).padStart(2, '0');
    document.getElementById("seconds").innerText = String(seconds).padStart(2, '0');

    if (totalSeconds > 0) totalSeconds--;
}

setInterval(updateTimer, 1000);