/**
 * Created by Ilgiz on 17.11.2016.
 */
$(document).ready(function () {
    showStaffs();

    $("#rents-btn").on("click", function () {
        showRents();
    });

    $("#hotel-btn").on("click", function () {
        showHotels();
    });

    $("#staff-btn").on("click", function () {
        showStaffs();
    });
});

function addStaff() {
    // $input = $("#js-tweet-text");
    // var text = $input.val();
    // if (text.length == 0) {
    //     return;
    // }
    // $.ajax({
    //     url: "/tweets/add",
    //     type: "POST",
    //     data: {
    //         text: text
    //     },
    //     success: function () {
    //         showStaffs();
    //     }
    // })
}


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

function showStaffs() {

    $.ajax({
        url: "/admin/getAllStaffs",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-data").html(data);
        }
    })
}