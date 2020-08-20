# Connected Components Kata

This project has born to explore a interesting problem with the help of TDD approch.
The problem is inspired by a question on Quora, and is the following:

- Given a black and white picture, recognize how many "connected areas" it contains,
where a connected area is composed of pixels of the same color. Two pixel are considered 
'connected' if they are orthogonally adjacent. - 

To explore the problema, I have decided to start with a simple version of it:
instead of a bidimensional picture, I'll adopt a mono-dimensional one, for example:
"IIIOOOIIII". In this case the picture is actually a string, and the number of components is 3.

The purpose of this kata are, in fact, at least two:
- explore how the use of "baby steps" approach allows to duplicated code emerge so that it 
can be successfully refactored into a fully formed algorithm
- ezplore how the TDD approach can be useful to "model" a problem: in this case 
one of the most difficult thing is arriving to a satisfying model of the picture

Final considerations:
- the final solution is not optimized in terms of performance (by choice)
- the TDD approach has not benn too useful in passing from the 1-dimension version of the problem to the 2-dimension one
- thinking in terms of "recursion" aid to implement a cleaner algorithm
- better if you start "in the middle": not from the corner (point 0,0 in the grid) and initially avoiding edge cases
 (as empty grid or linear grid, or even too small grid). So the TDD has more chance to develop soon the right solution;
 in fact, starting from the corner hides the following problem: you cannot move always on the right and down, while searching
 all points connected to the starting point, because some areas have a shape the "returns" back, so you have to move
 from the current point in all four directions to add more adjacent points to the current Connection.
 
 Anyway, there is a tension between two different approaches:
 - starting from the simplest cases (one dimension, simple shapes for connections) allows to not get stuck and arrive soon at 
   a partial solution, but requires a strong jump to obtain the complete and more general solution
 - starting from "the middle" in some cases seems more difficult, but it is actually preferable if the simpler cases
   are not easily generalizable.
