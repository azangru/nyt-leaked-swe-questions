import React, { Component } from 'react';
import './Stopwatch.css';

class Stopwatch extends Component {
  state = {
    currentTime: null,
    startTime: null
  }

  componentDidMount() {
    this.setState({
      startTime: Date.now(),
      currentTime: Date.now()
    });

    this.start();
  }

  start () {
    this.timerInterval = setInterval(() => {
      this.setState({currentTime: Date.now()});
    }, 1000);
  }

  render() {
    const {startTime, currentTime} = this.state;

    return (
      <div className="Stopwatch">
        <div className="Stopwatch-display">
        {currentTime - startTime}
        </div>
      </div>
    );
  }
}

export default Stopwatch;
