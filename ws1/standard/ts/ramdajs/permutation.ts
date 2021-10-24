function remove<T>(set: Set<T>, item: T) {
    const newSet = new Set<T>([...set]);
    newSet.delete(item)
    return newSet;
}
function flattern(array: Array<any>): Array<any> {
    if (!Array.isArray(array)) {
        return array;
    }
    return ([] as Array<any>).concat(...array.map(flattern))
}
function permutation(str: string) {
    function R(set: Set<string>): Array<string> {
        if (set.size === 1) {
            return [set.values().next().value]
        }
        return flattern([...set].map((char) =>
            R(remove(set, char)).map((perm) =>
                char + perm)
        ))
    }
    return R(new Set([...str]))
}

console.log(permutation("abc"))

// console.log(flattern([1,2,3,[6,7],[6,0,[6,4],8]]))