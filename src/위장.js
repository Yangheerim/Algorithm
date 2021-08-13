function solution(clothes) {
    let answer = 1;

    let obj={};
    for(let i=0;i<clothes.length;i++){
        obj[clothes[i][1]]=(obj[clothes[i][1]] || 1) + 1; //obj에 해당 키가 없으면 값을 1(옷을 입지 않은 경우)로 지정하고 1(옷의 개수)을 더해줌.
    }

    for(let key in obj){
        answer *= obj[key];
    }

    return answer-1; //최소한 1가지 이상의 옷을 입기 떄문에 옷을 입지 않은 경우 제외.

}