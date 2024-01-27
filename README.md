# ChatterBox
ChatterBox is a RESTful console-based AI chat bot application powered by OpenAI's GPT-3.5 Turbo. This application fetches the response from the API and returns it. This is just a module meant for the chat functionality. If you want to add modules to it or add this application as a microservice/module in your application, fork it or clone it as needed.

This application has context retention, meaning that the chatbot maintains the history of the conversation thread that is currently running. To keep it really simple, I have not implemented a database to persist the threads. In other words, the application doesn't persist the conversations. Once closed, the thread is garbaged. The next time the user starts the application, it just starts a new thread with no history of the previous conversation/s. The reason for doing this is to just have it serve the purpose of the current chat. If you, as a developer, want to implement persistence or history retention, just read the below point for understanding how you may/could do it.


## Working out the retention in the current application
As mentioned earlier, the current version just retains the history of the ongoing conversation. However, if you have played around with OpenAI's GPT-3.5 Turbo API, you know that the endpoint requires us to send in a String, and it in turn returns a String as a response which we need to catch. Instead of that, I modified it slightly by sending in a List of Strings so that the context in the ongoing conversation thread is retained. So, before exiting the application after the user prompts to, you can save the thread but throwing it to your calling microservice which can then dump it on to your database.
