# ConnectedComponentsKata

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
