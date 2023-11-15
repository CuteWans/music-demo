package org.note;

import javax.sound.midi.*;

public class MynoteImpl {
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        //获得序列器(播放器),新建序列,创建轨道
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.setTempoInBPM(90);
        Sequence sequence = new Sequence(Sequence.PPQ, 4 );
        sequencer.setSequence(sequence);
        Track track = sequence.createTrack();
        //创建一个音符,并添加到播放轨道
        ShortMessage shortMessage = new ShortMessage(ShortMessage.NOTE_ON,0,60,100);
        MidiEvent midiEvent = new MidiEvent(shortMessage,0);
        track.add(midiEvent);
        //打开序列器,播放音符
        sequencer.open();
        sequencer.start();
    }
}
