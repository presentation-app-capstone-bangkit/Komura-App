//package com.example.komura
//
//
//import org.bytedeco.opencv.global.opencv_highgui.destroyAllWindows
//import org.bytedeco.opencv.global.opencv_highgui.imshow
//import org.bytedeco.opencv.global.opencv_highgui.waitKey
//import org.bytedeco.opencv.opencv_core.Mat
//import org.bytedeco.opencv.opencv_core.Point
//import org.bytedeco.opencv.opencv_videoio.VideoCapture
//
//class MediaPipePose(
//    private val minDetectionConfidence: Float = 0.5f,
//    private val minTrackingConfidence: Float = 0.5f
//) {
//
//    fun processFrame(frame: Mat): List<Any> {
//        return listOf(org.opencv.core.Point(100.0, 200.0), org.opencv.core.Point(200.0, 200.0))
//    }
//}
//
//fun calculateDistance(point1: Point, point2: Point): Double {
//    return Math.sqrt(Math.pow((point1.x() - point2.x()).toDouble(), 2.0) + Math.pow((point1.y() - point2.y()).toDouble(), 2.0))
//}
//
//fun main(videoPath: String) {
//    val cap = VideoCapture(videoPath)
//    val pose = MediaPipePose()
//
//    var totalFrames = 0
//    var goodPostureFrames = 0
//    var badPostureFrames = 0
//
//    while (cap.isOpened) {
//        val frame = Mat()
//        cap.read(frame)
//        if (frame.empty()) {
//            break
//        }
//
//        val landmarks = pose.processFrame(frame)
//
//        if (landmarks.size >= 2) {
//            val shoulderDistance = calculateDistance(landmarks[0] as Point, landmarks[1] as Point)
//            if (shoulderDistance in 50.0..200.0) {
//                goodPostureFrames++
//            } else {
//                badPostureFrames++
//            }
//        }
//
//        totalFrames++
//
//        imshow("Pose Detection", frame)
//
//        if (waitKey(10) == 27) {
//            break
//        }
//    }
//
//    cap.release()
//    destroyAllWindows()
//
//    println("Posture Analysis:")
//    println(" - Good Posture Frames: $goodPostureFrames")
//    println(" - Bad Posture Frames: $badPostureFrames")
//}
//
//fun main() {
//    val videoPath = "path_to_video.mp4"
//    main(videoPath)
//}