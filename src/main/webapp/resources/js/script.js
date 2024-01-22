function getClickCoordinates(e) {
    console.log(e.offsetX);
    console.log(e.offsetY);

    let rVal =  document.getElementById("j_idt8:rOutput").innerHTML;
    let x = (e.offsetX - 150) / 100 * rVal;
    let y = -(e.offsetY - 150) / 100 * rVal;
    document.getElementById("j_idt8:graphicX").value = x;
    document.getElementById("j_idt8:graphicY").value = y;
    document.getElementById("j_idt8:xValue").value = true;
    document.getElementById("j_idt8:submitGraphic").click();

    console.log(x);
    console.log(y);
    console.log(rVal);
}
document.getElementById("graphic").addEventListener('click', getClickCoordinates);