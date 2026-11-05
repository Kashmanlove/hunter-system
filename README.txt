HUNTER SYSTEM
=============

A Solo Leveling style daily mission app for Android.
Works offline, has its own icon, and sends notifications at the 7 mission times.

DOWNLOAD AND INSTALL
--------------------

Direct link (open this on your phone):

  https://github.com/Kashmanlove/hunter-system/releases/latest/download/HunterSystem.apk

Or open the release page and tap HunterSystem.apk:

  https://github.com/Kashmanlove/hunter-system/releases/latest

Steps on the phone:

  1. Open the link in Chrome.
  2. Tap Download. Android may say the file type can harm your device
     (that is normal for any app outside the Play Store). Tap Download anyway.
  3. Open the downloaded HunterSystem.apk.
  4. Android asks to allow installs from this source. Allow it.
  5. If Play Protect warns about an unknown app, tap Install anyway.
     It is your own app, built from this repository.
  6. Open Hunter System and allow notifications when asked.


WHAT YOU GET
------------

  - Full screen, own icon, works offline.
  - Notifications with sound and vibration at 07:00, 11:00, 15:00, 17:00,
    18:30, 20:30 and 22:00, even when the app is closed.
    They can arrive a few minutes late while the phone is in battery saving.
  - Progress is saved inside the app on the phone.
    Use Hall > Copy backup now and then.


UPDATING LATER
--------------

The web app lives in:

  app/src/main/assets/index.html

Replace that one file, then rebuild. The new APK installs over the old one
and keeps your progress, because the signing key stays the same.


BUILDING IT YOURSELF
--------------------

Needs Java 17 and the Android SDK (platform 34, build-tools 34.0.0).

  gradle assembleDebug

The APK appears at:

  app/build/outputs/apk/debug/app-debug.apk


NOTES
-----

  - Android only. iPhone cannot install apps this way.
  - To turn the alerts off: phone Settings > Apps > Hunter System > Notifications.
  - The signing key (app/hunter.keystore) is for personal use only.
