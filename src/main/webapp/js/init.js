/**
 * Use me to init the printers and materials on the site.
 * 
 * 
 */

function initPage() {
    // get the printers
    // get the materials

    // set the list, just the names, and the types to the 2 different list windows.
    $.getJSON('printer/all', function(data) {
        $.each(data, function(key, val) {
            $("#printers").append("<li id=" + val.mvpPrinterId + "><input type='checkbox' name='" + val.mvpPrinterId + "'>" + val.name + "</input></li>");
        });
    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });

    $.getJSON('material/all', function(data) {
        $.each(data, function(key, val) {
            var liValue = val.name + " " + val.size + "mm";
            $("#filament").append("<li id=" + val.mvpMaterialId + "><input type='checkbox' name='" + val.mvpMaterialId + "' >" + liValue  + "</input></li>");
        });

    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });
}
