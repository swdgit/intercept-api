/**
 * 
 */
/**
 * @param filamentId
 */


function getPrinters(filamentId) {
    // get the printers that this filament will support
    $.getJSON('api/printers', function(data) {
        $.each(data, function(key, val) {
            $("#printers").append("<li id=" + val.printerId + ">" + val.name + "</li>");
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
            $("#materials").append("<li id=" + val.filamentId + ">" + liValue  + "</li>");
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
function getSpec() {
    // if the filament id and the printer id are not null then pull up a spec that matches both.
    var selectedPrinter  = $( "#printers" ).val();
    var selectedMaterial = $( "#materials" ).val();
    
    $.getJSON('ps/specs/' + selectedPrinter + '/' + selectedMaterial, function(data) {
        $.each(data, function(key, val) {
            $("#specs").append("<li id='" + val.title + "'>" + val.title + "</li>");
            
            var softSpecs = val.mvpPrintSpecifications;
            for (var i = 0; i < softSpecs.length; i++ ) {
                var softSpec = val.mvpPrintSpecifications[i];
                $("#specs").append("<li id='" + softSpec.mvpPrintSpecificationId + "'><a href='" + softSpec.profileFileUrl + "'>" + softSpec.title  + "</a></li>");
            }
            
            // top level is software with recursive specs via mvpPrinterSpecifications
            // e.g. Cura - [spec 1 , spec 2]
//            <ul class="matchLists" id="specs">
//              <li id="val.title">Cura
//                <ul id="val.mvpSoftwareId">
//                  <li id="val.mvpPrintSpecifications[i]"> val.mvpPrintSpecifications[i].title (url a href) </li>
//                  <li id="val.mvpPrintSpecifications[i]"> val.mvpPrintSpecifications[i].title (url a href) </li>
//                </ul>
//              </li>
//              etc
//              <li>Repetier<ul><li>spec 1</li><li>spec 2</li></ul></li>
//            </ul>
            
//            $("#specs").append("<li id='" + val.mvpPrintSpecificationId + "'><a href='" + val.profileFileUrl + "'> Profile : " + val.mvpPrintSpecificationId  + "</a></li>");

        });

    }).error(function(jqXHR, textStatus, errorThrown) {
        console.log("error " + textStatus);
        console.log("incoming Text " + jqXHR.responseText);
    });
}