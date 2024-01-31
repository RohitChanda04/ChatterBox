# ChatterBox
ChatterBox is a RESTful console-based AI chatbot application powered by OpenAI's GPT-3.5 Turbo. This application fetches the response from the API and returns it. This is just a module meant for the chat functionality. If you want to add modules to it or add this application as a microservice/module in your application, fork it or clone it as needed.

<br>

🔧 ***Technical Highlights***:

- **Tech Stack:** Java, Spring Boot
- **API Integration:** GPT-3.5 Turbo from OpenAI
- **Communication Protocol:** RESTful using HTTP commands
- **Console Interface:** Currently in a rudimentary form, but fully functional

<br>

💡 ***Key Features & Future Plans***:

- ✨ Seamless integration with GPT-3.5 Turbo for intelligent responses.
- 🌐 RESTful architecture for smooth communication.
- 💻 Console-based UI for simplicity, but UI enhancements in the pipeline.
- 🗃️ Future plans include implementing a database for storing chat threads.

🚀 I'm open to feedback and collaboration, so feel free to check out the code, clone/fork the repo, and drop your thoughts!

<br>

## Trying out ChatterBox
This application has context retention, meaning that the chatbot maintains the history of the conversation thread that is currently running. However, to keep it really simple, I have not implemented a database to persist the threads. In other words, the application doesn't persist the conversations. Once closed, the thread is garbaged. The next time the user starts the application, it just starts a new thread with no history of the previous conversation/s. The reason for doing this is to just have it serve the purpose of the current chat. I have future plans to implement the database, have a UI and create user profiles so that every use could log in and see all of his/her chat threads.

If you just want to try out the existing version of the application, you can clone it and run it locally. To clone the repository, you can follow any of the following commands :-

1. Using HTTPS:
`git clone https://github.com/RohitChanda04/ChatterBox.git`

2. Using SSH:
`git clone git@github.com:RohitChanda04/ChatterBox.git`

3. Using GitHUB CLI:
`gh repo clone RohitChanda04/ChatterBox`


If you, as a developer, want to work on the repo and contribute to it, kindly read the below point for understanding the structure of the project.

<br>

## Contributing to ChatterBox
As mentioned earlier, the current version just retains the history of the ongoing conversation. However, if you have played around with OpenAI's GPT-3.5 Turbo API, you know that the endpoint requires us to send in a String, and it in turn returns a String as a response which we need to catch. Instead of that, I modified it slightly by sending in a List of Strings so that the context in the ongoing conversation thread is retained. So, before exiting the application after the user prompts to, you can save the thread but throwing it to your calling microservice which can then dump it on to your database.

You need to implement a database of your choice and type, and then insert the current thread as a new thread or add to an existing one before the `System.exit(0);` exit command. The database can either be implemented in the same project or bette if is kept in another microservice which is just meant to connect to the database.

You can fork the project into your GitHub account and then clone it to your locally system. You can then try it out and make changes if you want to. If you want me them to be incorporated into the main branch of this repo, commit and push your changes to your forked copy and then create a pull request so that I can read and review them. I will connect with you and then I can merge your changes to the main branch if they elevate the overall experience of the application.

<br>

## Ending Note
Thanks for reading so far. If you liked going through the project and enjoyed using the application, feel free to visit me on other platforms too :-
- [LinkedIn](https://www.linkedin.com/in/rohit-chanda-b20763b6/).
- [Spotify](https://open.spotify.com/artist/4rMtJmvZ6GIJVPIet4zVSt).
- [YouTube](https://www.youtube.com/channel/UCcCyDGiYQ-R_zHOycwTrS9Q).

Yes, I produce songs and sing too :)

