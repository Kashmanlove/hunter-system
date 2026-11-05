HUNTER SYSTEM - Android app (builds free in the cloud, then you tap the file to install)

You need: a free GitHub account (github.com) and a computer for the first setup.
Nothing to install on the computer.

STEP 1  Make a repository
  - On github.com click the + (top right) > New repository.
  - Name it hunter-system. Choose Public. Click Create repository.

STEP 2  Upload these files
  - Unzip this folder first.
  - On the new repository page click "uploading an existing file".
  - Open the unzipped folder and drag EVERYTHING in it into the page,
    including the hidden folder named .github (on Mac press Cmd+Shift+. to show hidden folders).
  - Click Commit changes.
  - Check: the repository must list a folder called .github. If it does not,
    click Add file > Create new file, type  .github/workflows/build.yml  as the name,
    paste the text from BUILD-WORKFLOW-COPY.txt, and commit.

STEP 3  Wait for the build (about 5 to 10 minutes)
  - Click the Actions tab. If asked, click "I understand my workflows, enable them".
  - A run called "Build APK" starts by itself. Wait for the green tick.
    (No run? Click Build APK on the left, then Run workflow.)

STEP 4  Install on your phone
  - On your phone open your repository page, tap Releases (right side or below the files),
    tap "Hunter System", then tap HunterSystem.apk to download it.
  - Open the downloaded file. Android asks to allow installs from your browser: allow it.
    If Play Protect warns about an unknown app, tap Install anyway. It is your own app.
  - Open Hunter System. Allow notifications when asked.

WHAT YOU GET
  - Opens full screen with its own icon, works offline.
  - Phone notifications with sound and vibration at the 7 mission start times
    (07:00, 11:00, 15:00, 17:00, 18:30, 20:30, 22:00), even when the app is closed.
    They can arrive a few minutes late when the phone is in battery saving.
  - Your progress is saved inside the app on your phone. Use Hall > Copy backup now and then.

UPDATING LATER
  - Replace the file app/src/main/assets/index.html in the repository with a new one
    (or ask Claude for a new zip). The build runs again and the new HunterSystem.apk
    installs over the old one without losing progress.

IF THE BUILD FAILS (red cross in Actions)
  - Click the failed run, open the "Build the app" step, copy the red error text,
    and send it to Claude. It could not be test-built where this was written.

NOTES
  - Android only. iPhone cannot install apps this way.
  - To turn the alerts off: phone Settings > Apps > Hunter System > Notifications.
  - The signing key in this project is for your personal use only.
