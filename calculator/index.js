const display = document.getElementById('display');

let prevVal = 0;

document.querySelector('.clear').addEventListener('click',()=>{
    prevVal = 0;
    display.innerText = 0;
})

document.querySelector('.buttons').addEventListener('click',(e)=>{
    let btnVal = e.target.innerText;
    switch(btnVal){
        case "+" : display.innerText = prevVal + parseInt(btnVal); break;
        case "-" : display.innerText = prevVal - parseInt(btnVal); break;
        case "*" : display.innerText = prevVal * parseInt(btnVal); break;
        case "/" : display.innerText = prevVal / parseInt(btnVal); break;
        case "=" : display.innerText = prevVal; break;
        default : prevVal = parseInt(btnVal);
    }
    display.innerText = btnVal;
})

