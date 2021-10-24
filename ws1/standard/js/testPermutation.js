"use strict";
function remove(set, item) {
    const newSet = new Set([...set]);
    newSet.delete(item);
    return newSet;
}
//flattern的作用就是把数组合并
function flattern(array) {
    if (!Array.isArray(array)) {
        return array;
    }
    // console.log(array,...array)
    return [].concat(...array.map(flattern));
}
function permutation(str) {
    function R(set) {
        if (set.size === 1) {
            return [set.values().next().value];
        }
        return flattern([...set].map((char) => {
            let r = R(remove(set, char));
            // console.log(char,set,r)
            return r.map((perm) => char + perm);
        }));
        //console.log(a,set[a,b,c],param[b,c])
        //console.log(b,set[b,c],param[c])=>打印b Set(2) {'b', 'c'} ['c']
        //console.log(c,set[b,c],param[b])
    }
    return R(new Set([...str]));
}
console.log(permutation("abc"));
console.log([].concat([1, 2], [1, 5]));
