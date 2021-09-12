function content(){
    const content=document.createElement('div')
    content.innerHTML='我是外部引入的content'
    app.appendChild(content)
}
export default Content