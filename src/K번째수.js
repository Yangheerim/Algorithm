let array = [1, 5, 2, 6, 3, 7, 4];
let commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];

solution(array, commands);

function solution(array, commands) {
    var answer = [];

    for(var tk =0; tk<commands.length; tk++){
        var now = array.slice(commands[tk][0]-1,commands[tk][1]);
        now.sort((a,b)=> a - b)
        answer.push(now[commands[tk][2]-1]);
    }

    console.log(answer)

    return answer;

}