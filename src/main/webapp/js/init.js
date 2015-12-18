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
            $("#printers").append("<option value='" + val.mvpPrinterId + "'>" + val.name + "</option>");
        });
        $("#printers").append("<option value='-1'>Add New Printer</option>");
    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });

    $.getJSON('material/all', function(data) {
        $.each(data, function(key, val) {
            var liValue = val.name + " " + val.size + "mm";
            $("#materials").append("<option value='" + val.mvpMaterialId + "'>" + liValue  + "</option>");
        });
        $("#materials").append("<option value='-1'>Add New Material</option>");

    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });
}
