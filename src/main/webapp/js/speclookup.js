/**
 * 
 */
/**
 * @param filamentId
 */

var selectedPrinter = '0';
var selectedMaterial = '0';

function getPrinters(filamentId) {
    // get the printers that this filament will support
    $.getJSON('api/printers', function(data) {
        $.each(data, function(key, val) {
            $("#printer").append("<li id=" + val.printerId + ">" + val.name + "</li>");
        });
    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });
}

/**
 * @param printerId
 */
function getFilaments(printerId) {
    // get the filaments that this printer will print with.
    $.getJSON('api/filament', function(data) {
        $.each(data, function(key, val) {
            var liValue = val.name + " " + val.color + " " + val.size;
            $("#material").append("<li id=" + val.filamentId + ">" + liValue  + "</li>");
        });

    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });
}

/**
 * @param filamentId
 * @param printerId
 */
function getSpec(materialId, printerId) {
    // if the filament id and the printer id are not null then pull up a spec that matches both.
    
}

$('#printer li').click(function() {
    selectedPrinter = $(this).attr('value');
});

$('#material li').click(function() {
    selectedMaterial = $(this).attr('value');
});