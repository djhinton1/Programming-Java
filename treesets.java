/*treesets & hashsets

TREESET: fast insertion, maintains sort, disregards duplicates
original order: M,F,Q,A,H,P,Z.

M becomes the root and then we look at F, is is less than M? yes. then it gets put to the left of M.

memory is fragemented. memory is allocated as new elements are added.

can not store duplicates
trees are O(log(n)) for all operations

----------------------------------------------------------
HASHSET: fast insertion and lookup
start with a pretty big array
h(s) produces an index into the array

converts elements into their number forms and puts them into an array where the initialized elements aren't packed ot the front and there are blocks of uninitialized array.

allows for: exists(s) and it will return true or false. this is the look up. 

both insert and lookup are done in O(1) time. its actually O(1) for all operations.

h("foo") turns into the ASCII number and then uses those numbers as the coefficients in a hashing function.

-----------------------------------------------------------
BOGGLE GAME: 
store dictionary in HASHSET.
store hit words in a TREESET

need a heuristic (returning from recursion early)
	this is the circumstance under which we can just return from the
	call without growing the string by tacking on one of the
	neighbors
	
	after no this string is not a word,
	ask, is this string a prefix for any other word in the
	dictionary?
	
	of not, just return there; dont bother looking for more words
	if yes, then drop down and search N, NW, W, SW, S etc.
	
	
	this game is literally just the swamp.
	
	instead of asking is this tile a safe tile (i.e. 1), ask
	is the word i just formed in the dictionary? if yes then good,
	keep going, if not then ask, is this loser even a prefix for
	other words, if yes then keep going, but if not then just
	return.









*/