function getClickCoordinates(e) {
    let rVal = "#{controller.getrValue()}";
    let x = (e.offsetX - 150) / 100 * rVal;
    let y = -(e.offsetY - 150) / 100 * rVal;
    document.getElementById("j_idt6:graphicX").value = x;
    document.getElementById("j_idt6:graphicY").value = y;
    document.getElementById("j_idt6:xValue").value = true;
    document.getElementById("j_idt6:submitGraphic").click();

}
document.getElementById("graphic").addEventListener('click', getClickCoordinates);