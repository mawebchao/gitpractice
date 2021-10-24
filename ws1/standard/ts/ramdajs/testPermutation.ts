function remove<T>(set: Set<T>, item: T) {
    const newSet = new Set<T>([...set]);
    newSet.delete(item)
    return newSet;
}
//flattern的作用就是把数组合并
function flattern(array: Array<any>): Array<any> {
    if (!Array.isArray(array)) {
        return array;
    }
    // console.log(array,...array)
    return ([] as Array<any>).concat(...array.map(flattern))
}
function permutation(str: string) {
    function R(set: Set<string>): any {
        if (set.size === 1) {
            return [set.values().next().value]
        }
        return flattern([...set].map((char) =>
            {
                let r=R(remove(set, char))
                // console.log(char,set,r)
                return r.map((perm:any) =>
                char + perm)
            }
        ))
        //console.log(a,set[a,b,c],param[b,c])
        //console.log(b,set[b,c],param[c])=>打印b Set(2) {'b', 'c'} ['c']
        //console.log(c,set[b,c],param[b])
    }
    return R(new Set([...str]))
}

console.log(permutation("abc"))

console.log(([] as Array<any>).concat([1,2],[1,5]))