import service from './service'
export function get(url, param) {
    const options = {
        url: url,
        method: 'get'
    }
    if (param) options.params = param
    return service(options)
}
export function post(url, param) {
    const options = {
        url: url,
        method: 'post'
    }
    if (param) options.data = param
    return service(options)
}