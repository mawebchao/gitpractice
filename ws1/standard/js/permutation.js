"use strict";
function remove(set, item) {
    const newSet = new Set([...set]);
    newSet.delete(item);
    return newSet;
}
function flattern(array) {
    if (!Array.isArray(array)) {
        return array;
    }
    return [].concat(...array.map(flattern));
}
function permutation(str) {
    function R(set) {
        if (set.size === 1) {
            return [set.values().next().value];
        }
        return flattern([...set].map((char) => R(remove(set, char)).map((perm) => char + perm)));
    }
    return R(new Set([...str]));
}
console.log(permutation("abc"));
// console.log(flattern([1,2,3,[6,7],[6,0,[6,4],8]]))
