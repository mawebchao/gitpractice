function delaylog(item){
    return new Promise((resolve)=>{
        setTimeout(()=>{
            resolve(item)
        },1000)
    })
}
function processorArr(arr){
    arr.forEach(async element => {
        console.log(await delaylog(element))
    });
    console.log("打印完毕")
}
processorArr([1,2,3])