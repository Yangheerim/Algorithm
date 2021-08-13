let numbers = [6, 10, 2];

function solution(numbers) {
    let answer = numbers
        .map(c=> c + '') //각 숫자들을 문자로 변환(1 => '1')
        .sort((a,b) => (b+a) - (a+b)) //문자로 변환된 숫자를 연결하여 비교정렬 ( '3', '30' => ('303')-('330'))
        .join('');  //.join('') = 문자열 합치기

    return answer[0]==='0'? '0' : answer; //numbers 배열이 0으로만 구성되어 있을 경우 '0'만 출력
}


// https://velog.io/@fastpace04/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4JavaScript-%EA%B0%80%EC%9E%A5-%ED%81%B0-%EC%88%98
