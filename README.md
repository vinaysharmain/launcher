# MinLauncher

A minimal Android launcher with a clean, distraction-free design.

## Features

- **Pure black background** (#000000)
- **White text only** - no icons or colors
- **Monospace font** for clean typography
- **Essential apps only** - reduces phone addiction
- **Text-based interface** - maximum simplicity

## Getting the APK

### Option 1: Download Pre-built APK (Recommended)

1. Go to the [Releases page](../../releases)
2. Download the latest `MinLauncher.apk` file
3. Install on your Android device (see installation instructions below)

### Option 2: Build from Source

If you have Android Studio or Java installed:

```bash
cd android-launcher
./gradlew assembleDebug
```

The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

## Installation Instructions

1. **Enable Unknown Sources:**
   - Go to Settings > Security (or Privacy)
   - Enable "Install from unknown sources" or "Unknown sources"
   - (On newer Android versions: Settings > Apps > Special access > Install unknown apps)

2. **Install the APK:**
   - Download the `MinLauncher.apk` file to your phone
   - Tap the APK file to install
   - Follow the installation prompts

3. **Set as Default Launcher:**
   - Press the Home button
   - Select "MinLauncher" 
   - Choose "Always" to set as default

## Design Preview

Open `ui-preview.html` in your browser to see how the launcher will look.

## Customization

The launcher shows essential apps in a minimal text-only interface. To modify which apps are considered "essential", edit the filtering logic in `LauncherActivity.java`.

## Requirements

- Android 5.0 (API level 21) or higher
- Approximately 2MB storage space