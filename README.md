# VibrationPatternTool
A very simple tool to create vibration patterns on your phone

I'm always looking for unique vibration patterns to give users unique tactile feedback. Vibration is to mobile devices the same
way that sound can be for larger programs- an identifier as well as a plesant sensory experience. Instead of experimenting with
various array patterns and having to test the newly created array on an android device each time, I put this together one night
so I could experiment with patterns simple and complex anywhere I had my phone.

The editable text box at the top of the screen takes in a comma deliminated list of intergers that act as alternating "On" and 
"Off" signals for the vibrator in the phone in milliseconds. The "Commit to array" button below passes those values as an array
of longs, which can be used by the vibrate call. The first value is always set to 0 to ensure there is no delay before the pattern
begins. The "Vibrate" button will then cause the phone to vibrate to that set pattern on a loop.

I may add a toggle button for whether or not the pattern repeats in the future, as well as a method to store patterns in the future.
