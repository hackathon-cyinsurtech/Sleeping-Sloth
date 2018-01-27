# Sleeping-Sloth


RESTful endpoints:

- POST: /answer/add
- GET: /answer/all

- POST: /insurancetype/add
- GET: /insurancetype/all

- POST: /question/add [Question]
- POST: /question/addChoice [QuestionChoice]
- GET: /question/all
- GET: /question/type?questionType=
- GET: /question/choices?questionId=


- GET: /user/add?
@RequestParam String email, 
@RequestParam String password,
@RequestParam String name,
@RequestParam String surname,
@RequestParam String address,
@RequestParam UserType type
- GET: /user/all
- GET: /user/load?email=EMAIL&password=PASSWORD
- GET: /user/loadUser?email	


/quote/find?userId=1
/quote/add
/quote/all

/answer/findRegistrationNumberForQuote?quoteRequestId=3
