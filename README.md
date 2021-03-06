check lines below start with 🚀 for comments of those questions.


```
Instruction: Try to implement the below problment Statement in Java and if time permits do it in Python as well. 

🚀 I will implement this problem using only Java with 2 approaches [GET /animate] and [GET /animate-para], check the source code for more details.

Can you think of how to extend the scope of the problem? 

🚀 @see https://en.wikipedia.org/wiki/N-body_problem

Do you think Java solution to the above problem can be implementd with Spring boot in a better way? 
If answer is yes do it. if anser is no, explain. 

🚀 I am going to use spring boot since it is easier to set API server up.

Submit your code for our review either by checkin to your own public github repo (and share your repo URL) or send us by email.

Problem Statement
A collection of particles is contained in a linear chamber. They all have the same speed, but some are headed toward the right and others are headed toward the left. These particles can pass through each other without disturbing the motion of the particles, so all the particles will leave the chamber relatively quickly.
You will be given the initial conditions by a String init containing at each position an 'L' for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty location. init shows all the positions in the chamber. Initially, no location in the chamber contains two particles passing through each other.
We would like an animation of the process. At each unit of time, we want a string showing occupied locations with an 'X' and unoccupied locations with a '.'. Create a class Animation that contains a method animate that is given an int speed and a String init giving the initial conditions. The speed is the number of positions each particle moves in one time unit.
The method will return an array of strings in which each successive element shows the occupied locations at the next time unit. The first element of the return should show the occupied locations at the initial instant (at time = 0) in the 'X', '.' format. The last element in the return should show the empty chamber at the first time that it becomes empty.

Input function signature example
Here are some input function examples:

// Java Function signature:
static List<String> animate(int speed, string init)

# python Function signature:
def animate(speed, init)

Alternatively you can develop a webservice taking inputs as JSON and returning a String:
# JSON: 
# {
#     "speed": 2,
#     "init": "LR..RL..RRLLLRRL..RLR.."
# }

curl -X GET "http://server:port/animate" \
    -H "Content-Type: application/json" \
    -d '{ "speed": 2, "init": "LR..RL" }'

🚀 curl -X GET "http://localhost:8080/animate" -H "Content-Type: application/json" -d '{ "speed": 1, "init": "LRRL.LR.LRR.R.LRRL." }'
🚀 curl -X GET "http://localhost:8080/animate-para" -H "Content-Type: application/json" -d '{ "speed": 1, "init": "LRRL.LR.LRR.R.LRRL." }'

Constraints
You may assume the following constraints:
•	speed will be between 1 and 10 inclusive
•	init will contain between 1 and 50 characters inclusive
•	each character in init will be '.' or 'L' or 'R'
Examples
(Note that in the examples below, the double quotes should not be considered part of the input or output strings.)
0) 2, "..R...."
Returns:
{"..X....",
 "....X..",
 "......X",
 "......."}
The single particle starts at the 3rd position, moves to the 5th, then 7th, and then out of the chamber.
1) 3, "RR..LRL"
Returns:
{"XX..XXX",
 ".X.XX..",
 "X.....X",
 "......."}
At time 1, there are actually 4 particles in the chamber, but two are passing through each other at the 4th position
2) 2, "LRLR.LRLR"
Returns:
{"XXXX.XXXX",
 "X..X.X..X",
 ".X.X.X.X.",
 ".X.....X.",
 "........."}
At time 0 there are 8 particles. At time 1, there are still 6 particles, but only 4 positions are occupied since particles are passing through each other.
3) 10, "RLRLRLRLRL"
Returns:
{"XXXXXXXXXX",
 ".........."}
These particles are moving so fast that they all exit the chamber by time 1.
4) 1, "..."
Returns:
{"..."}
5) 1, "LRRL.LR.LRR.R.LRRL."
Returns:
{"XXXX.XX.XXX.X.XXXX.",
 "..XXX..X..XX.X..XX.",
 ".X.XX.X.X..XX.XX.XX",
 "X.X.XX...X.XXXXX..X",
 ".X..XXX...X..XX.X..",
 "X..X..XX.X.XX.XX.X.",
 "..X....XX..XX..XX.X",
 ".X.....XXXX..X..XX.",
 "X.....X..XX...X..XX",
 ".....X..X.XX...X..X",
 "....X..X...XX...X..",
 "...X..X.....XX...X.",
 "..X..X.......XX...X",
 ".X..X.........XX...",
 "X..X...........XX..",
 "..X.............XX.",
 ".X...............XX",
 "X.................X",
 "..................."}
```