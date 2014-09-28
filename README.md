ECommerce Proof Of Concept application using Play Framework
=================================

## To run the application, you'll need to follow these instructions

1. Make sure you have MySQL installed. 
2. In `conf/application.conf` file, specify your MySQL root password for property named `db.default.password`. Of course, we can also run it with a non-root user as well. But that would require a few more steps.
3. In `conf/securesocial.conf` file, under the `smtp` section, replace `user` with your gmail username and `password` with your gmail password
4. On the command line, go to the dir where you have cloned the repo. Run the application using `./activator run`
5. Go to `localhost:9000`
6. After running the application for the first time, the schema will be generated automatically. Now, log into MySQL and execute the SQL that is available in `conf/base.sql`
7. Now, your application is ready to run and do it so by re-executing step 4.

User management can be done at: localhost:9000/users

You can sign up more users. There is already one admin user available. For this admin user, the details are:
email: bhashit.parikh@gmail.com
pass: abcdefgh


## Managing git branches

There can be merge conflicts, or some other problems while executing some of these commands. If they do occur, let me know, and I can help you out.

1. execute command `git checkout -b mybranch`. Here `mybranch` could by any name you want. This will create a new branch for your code. All your uncommited changes should now appear in this new branch.
2. Now, if the changes you have made are to your satisfaction, commit your changes using `git commit -a -m "your message"`, where `your message` can be any commit message that you want to specify.


This takes care of having your code in a separate branch.

Now, to pull in the code from the master branch, execute the following commands:

1. `git checkout master`
2. `git pull`
3. `git checkout mybranch`
4. `git rebase master`. This will merge all my changes with your code.
