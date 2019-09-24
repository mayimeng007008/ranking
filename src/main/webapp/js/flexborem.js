//获得屏幕大小
let htmlwidth = document.documentElement.clientWidth || document.body.clientWidth;  //浏览器兼容
console.log("屏幕宽度："+htmlwidth) //iphone5:320 iphone6:375

//获得html DOM元素
let htmlDom = document.getElementsByTagName('html')[0];

//给DOM元素设置样式
htmlDom.style.fontSize = htmlwidth/20 + 'px';  
//以iphone5为基础 iphone5默认字体大小为16px 320/16=20 即1rem字体大小是屏幕宽度的1/20
