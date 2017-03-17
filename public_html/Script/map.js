function initMap() {
    let mymap = L.map('mapid');

    let latElem = $("#latElem");
    let lonElem = $("#lonElem");

    $.get("/gps", function (data) {
        showPosition(data);
    });

    /*if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        console.log("Geolocation is not supported by this browser.");
    }*/

    //var mymap = L.map('mapid').setView([51.505, -0.09], 13);
    L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mymap);

    function showPosition(position) {
        const lat = position.lat;
        const lon = position.lon;
        lonElem.text(lon);
        latElem.text(lat);
        mymap.setView([lat, lon], 13);
        addMarker(lat, lon);
        console.log(lat + " " + lon);
    }

    this.addMarker = function (lat, lon) {
        var marker = L.marker([lat, lon]).addTo(mymap);
        return marker;
    }

    return this;
}