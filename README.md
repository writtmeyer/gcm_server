#Readme
This is a sample project to showcase Google Cloud Messaging using upstream messaging. This
project is a very simply standalone server. Though that's not part of this sample 
I was able to utilize this project from within a Java webapp.

The project was originally created for a talk I held at the [Dutch Android User Group](www.dutchaug.org) 
meeting in Utrecht on January, 16th 2014. If you ever have the possibility to 
visit a meeting of the Dutch AUG, I stringly recommend to do so. It has been a gorgeous evening!


##Libraries used
This project makes use of [Smack](http://www.igniterealtime.org/projects/smack/) and 
[Json-simple](http://code.google.com/p/json-simple/). The code is based on a sample class provided
by Google on the [XMPP documentation page](http://developer.android.com/google/gcm/ccs.html).


##Most important classes
All classes are within the `com.grokkingandroid.sampleapp.samples.gcm.ccs.server` package.

`CcsClient` contains a main method which takes three arguments:

1. The project number
2. The API key
3. A registration id to send a test message to

If you start it that way, the GUI of the Smack library is used to show incoming and outgoing messages.

Of course, you also can use `CcsClient` from within any other project. In my case I used it from within
a web project to send messages to the Android client.

In that case you first have to call `prepareClient()` and pass it the project number and the api key as arguments. 
The third argument decides whether the GUI should be shown or not. On servers you have to set this to `false`.

The registration ids of the Android clients and all message are stored in memory. This is managed by the 
`PseudoDao` class. This should help you to get started with a real persistence solution for production.

For this sample all incoming messages must follow a certain format. That is, they must contain at least
an `action` key with a supported value. This `action` key determines which `PayloadProcessor` to create. 
The implementations of `PayloadProcessor` (`EchoProcessor`, `MessageProcessor` and `RegisterProcessor`) 
finally handle the incoming messages and perform the appropriate actions.


##Credentials
**To run this project you need a GCM-project number and an API key.** You can read more about it on the 
[Getting Started page of Google's documentation](http://developer.android.com/google/gcm/gs.html).

Those are passed into the `CcsClient` by either calling the `prepareClient()` method or by providing those 
as arguments to the main method.

Keep in mind: For using Google Cloud Messaging with XMPP **you need to apply first**. 
See for example the note at the top of the [http://developer.android.com/google/gcm/notifications.html](User Notification page). 
You can find a current link there as well.


##Relevant Blogposts on [Grokking Android](http://www.grokkingandroid.com/)
Right now I haven't finished the blog post about GCM. It's in the making and should be up pretty soon.


##Developed by

*Wolfram Rittmeyer* - You can contact me via:

* [Grokking Android (my blog)](http://www.grokkingandroid.com)

* [Google+](https://plus.google.com/+WolframRittmeyer)

* [Twitter](https://twitter.com/RittmeyerW)


##Thanks
A big thanks to the organizers of the meetup in Utrecht. It was a great evening with good presentations 
and interesting conversations in the breaks!

Also thanks to all my readers and blog commenters. Your feedback helps me to stay on track and to go on 
with projects like this. Without my blog (and thus you) I probably woouln't have been invited in the first place :-)

Special thanks also to the Android crowd on G+. You're an awesome crowd. I have gained many insights 
by reading posts there, by following links to blog posts or by discussions on G+! And it was great to meet some of you
in Utrecht. 

And finally: This readme was created using [dillinger.io](http://dillinger.io). Thanks for this service.


##License
    Copyright 2014 Wolfram Rittmeyer

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

