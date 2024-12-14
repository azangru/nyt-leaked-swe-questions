import React from 'react';
import './FilterSelector.css';

const FilterSelector = ({ values, onSelectChange }) => {
    return (
        <div className="FilterSelectorSelect">
            <select defaultValue={'all'} onChange={e => onSelectChange(e.target.value)} className="SelectorDropDown">
                <option value={'all'}>All</option>
                {values.map(value => {
                    return <option key={value} value={value}>{value}</option>
                })}
            </select>
        </div>
    );
};

export default FilterSelector;