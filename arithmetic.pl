student(meet).
subject(oose).
subject(ai).
subject(mc).
birth(meet, date(9, 1, 1996)).
marks(meet, oose, 81).
marks(meet, ai, 80).
marks(meet, mc, 71).

details(X) :-
	write('DOB :: '),
	birth(X, date(Day, Month, Year)),
	write(Day-Month-Year),
	write('\n'),
	marks(X, oose, OOSE),
	marks(X, ai, AI),
	marks(X, mc, MC),
	Percent is (OOSE + AI + MC)/3,
	write('Percentage :: '),
	write(Percent).