function isNull(input){
    return input == null;
}

function isValid(input,min, max){
    console.log(input);
    return input >= min && input <= max;
}

function smaller(input,value){
    console.log(input);
    return input < value;
}

function larger(input,value){
    console.log(input);
    return input > value;
}
function largerOrEqual(input,value){
    console.log(input);
    return larger(input,value) || input == value;
}
function SmallOrEqual(input,value){
    console.log(input);
    return smaller(input,value) || input == value;
}

function TodayDate(date) {

    let d = date.getDate(),
        m = date.getMonth() + 1,
        y = date.getFullYear();

    if (d < 10) {
        d = "0" + d;
    };
    if (m < 10) {
        m = "0" + m;
    };
    return y + "-" + m + "-" + d;
}
function isBlank(item){
    return item.length == 0;
}
function ToNumber(...params){
    for (const item of params) {
        if(item.trim().length == 0){
            
            console.log("logger : ",item);
            item = null;
        }
        else{
            console.log("logger : ",item);
            item = Number(item);
        }
    }
}

export {isNull,isValid,smaller,larger,SmallOrEqual,largerOrEqual,TodayDate,ToNumber,isBlank};
