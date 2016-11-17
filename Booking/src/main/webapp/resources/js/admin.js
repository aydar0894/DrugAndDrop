/**
 * Created by Ilgiz on 17.11.2016.
 */
$(document).ready(function () {
    showRents();

    $("#rents-btn").on("click", function () {
        showRents();
    });

    $("#hotel-btn").on("click", function () {
        showHotels();
    });

    $("#staff-btn").on("click", function () {
        showRents();
    });
});


function showRents() {

    $.ajax({
        url: "/admin/getAllRents",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-data").html(data);
        }
    })
}

function showHotels() {

    $.ajax({
        url: "/admin/getAllHotels",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-data").html(data);
        }
    })
}

function showHotels() {

    $.ajax({
        url: "/admin/getAllHotels",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-data").html(data);
        }
    })
}